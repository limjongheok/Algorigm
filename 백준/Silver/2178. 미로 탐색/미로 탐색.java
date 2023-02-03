import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static  char[][] miro;
    static  boolean[][] visited;
    static  int countMap[][];
    static  int N;
    static  int M;


    static  int[] dx = {0,1,0,-1};
    static  int[] dy = {1,0,-1,0};

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

         st= new StringTokenizer(bf.readLine());
         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());

         miro = new char[N+1][M+1];
         countMap = new int[N+1][M+1];

         countMap[0][0] = 1;

         visited = new boolean[N+1][M+1];

         // 미로 작성
         for(int i=0; i<N; i++){
             String input = bf.readLine();
             for(int j=0; j<M; j++){
                 miro[i][j] = input.charAt(j);
             }
         }

         bfs(0,0);

         System.out.println(countMap[N-1][M-1]);




    }

    public static void bfs(int x, int y){
        // 0,0에서 시작
        // queue 생성
        Queue<dot> queue = new LinkedList<>();
        queue.add(new dot(x,y));
        visited[x][y] = true;

        while (!queue.isEmpty()){
            dot dot = queue.poll();
            //현재 x,y  봅기
            int nowX  = dot.x;
            int nowY = dot.y;



            // 상하 좌우 움직이기
            for(int i=0; i<4; i++){
                int moveX = nowX + dx[i];
                int moveY = nowY +dy[i];

                if(moveX>=0 && moveX<N){
                    if(moveY>=0 && moveY<M){

                        if(!visited[moveX][moveY] && miro[moveX][moveY] == '1'){

                            visited[moveX][moveY] = true;
                            queue.add(new dot(moveX,moveY));
                            countMap[moveX][moveY] = countMap[nowX][nowY] +1 ;


                        }

                    }
                }


            }



        }



    }

    protected static class  dot{
        int x;
        int y;

        public dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
