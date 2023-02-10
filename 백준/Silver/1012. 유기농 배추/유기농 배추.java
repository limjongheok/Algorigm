import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static  int T;
    static  int M; // 가로 길이
    static  int N; // 세로 길이
    static  int K; // 배추가 심어져 있는 위치 개수
    static  int array[][];
    static  boolean check[][];

    static  int[] dx = {0,1,0,-1};
    static  int[] dy = {-1,0,1,0};
    static  int count;
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(bf.readLine());
        for(int i=0; i<T; i++){
            st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken()); // 가로 길이
            M = Integer.parseInt(st.nextToken());// 세로 길이
            K = Integer.parseInt(st.nextToken());// 배추가 심어져 있는 위치 개수
            array = new int[N+1][M+1];
            check = new boolean[N+1][M+1];
            count =0; // count 초기화

            // 배추 추가
            for(int j=0; j<K; j++){
                st = new StringTokenizer(bf.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());

                array[X][Y] = 1;
            }
            for(int c=0; c<N; c++){
                for(int d=0; d<M; d++){
                    if(!check[c][d]){
                        if(array[c][d] ==1){

                            // 방문을 안했다면
                            bfs(c,d); // bfs 알고리즘 돌려주고
                            count++;
                        }


                    }
                }
            }
            System.out.println(count);



        }

    }
    public static void bfs(int x, int y){
        check[x][y] = true; // 방문 시켜주기
        Queue<dot> queue = new LinkedList<>();
        queue.add(new dot(x,y));
        while(!queue.isEmpty()){
            dot dot = queue.poll();
            int nowX = dot.x;
            int nowY = dot.y;


            // 상하 좌우로 x y 좌표 움직이기
            for(int i=0; i<4; i++){
                int nextX = nowX+dx[i];
                int nextY = nowY+dy[i];


                if(nextX>=0 && nextX<N){
                    if(nextY>=0 && nextY<M){

                        if(array[nextX][nextY] == 1){
                            // 방문을 하지 않았을 경우
                            if(!check[nextX][nextY]){
                                check[nextX][nextY] = true; // 방문 시키고

                                queue.add(new dot(nextX,nextY));
                            }
                        }


                    }
                }

            }

        }
    }

    protected static  class dot{
        int x;
        int y;

        public dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
