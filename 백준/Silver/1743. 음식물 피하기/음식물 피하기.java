
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static  int N; // 통로 세로 길이
    static  int M;// 통로 가로 길이
    static  int K; // 음식물 떨어진 좌표 개수

    static  int[] dx = {0,1,0,-1};
    static  int[] dy = {1,0,-1,0};


    static boolean[][] check;
    static boolean[][] board;

    static  int count = 0;

    static  int ans;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new boolean[N][M];


        check = new boolean[N][M];

        // 음식물 채우기
        for(int i=0; i<K; i++){
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            board[x-1][y-1]  = true;
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(board[i][j] == true && !check[i][j]){


                    dfs(i,j); // dfs 마다 ans가 알맞게 세짐
                    count = Math.max(count, ans);
                }

            }
        }

        System.out.println(count);

    }
    public static  void dfs(int x, int y ){



        Stack<dot> stack = new Stack<>();
        stack.add(new dot(x,y));
        check[x][y] = true;

        ans = 0;


        while(!stack.isEmpty()){
            dot dot = stack.pop();

            ans++;

            int nowX = dot.x;
            int nowY = dot.y;

            for(int i=0; i<4; i++){
                int nextX = nowX+ dx[i];
                int nextY = nowY + dy[i];

                if(nextX >=0 && nextX<N){
                    if(nextY>=0 && nextY<M){
                        if(check[nextX][nextY] == false){
                            if(board[nextX][nextY] == true){

                                check[nextX][nextY] = true; // 방문 시켜주고
                                stack.add(new dot(nextX,nextY)); // 스택에 담기
                            }


                        }
                    }


                }
            }
        }



    }
    private  static  class  dot{
        int x;
        int y;
        public dot(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
