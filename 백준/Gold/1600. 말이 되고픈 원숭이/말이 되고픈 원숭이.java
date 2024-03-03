import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int[][] arr;
    static boolean[][][] visited;
    static int ablity;
    static int n;
    static int m;
    static int[] mx = {0,0,1,-1};
    static int[] my =  {1,-1,0,0};
    static int[] hx = {-1,-2,-2,-1,1,2,2,1};
    static int[] hy = {-2,-1,1,2,-2,-1,1,2};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

         ablity = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
         m =Integer.parseInt(st.nextToken());
         n=  Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m][ablity+1];



        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(0,0);

    }
    private static void bfs(int x, int y){
        visited[x][y][0] = true;

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x,y,0));
        int count = 0;
        while(!queue.isEmpty()){
            int size = queue.size(); //
            for(int z=0; z<size; z++) {
                // 레벨별 bfs
                Node nowNode = queue.poll();
                int nowX = nowNode.x;
                int nowY = nowNode.y;
                int nowState = nowNode.state;

                if(nowX == n-1 && nowY == m-1){
                    System.out.println(count);
                    return;
                }

                // 원숭이 이동
                for(int i=0; i<4; i++){
                    int nextX = nowX +mx[i];
                    int nextY = nowY + my[i];
                    if(nextX >=0 && nextX <n){
                        if(nextY >=0 && nextY <m){
                            if(!visited[nextX][nextY][nowState]){
                                if(arr[nextX][nextY]!=1){
                                    visited[nextX][nextY][nowState] = true;
                                    queue.add(new Node(nextX,nextY,nowState));
                                }
                            }
                        }
                    }
                }

                if(nowState < ablity){ // 능력

                    // 말 이동
                    for(int i=0; i<8; i++){
                        int nextX = hx[i] + nowX;
                        int nextY = hy[i] + nowY;
                        int nextState = nowState +1;
                        if(nextX >=0 && nextX <n){
                            if(nextY >=0 && nextY <m){
                                if(!visited[nextX][nextY][nextState]){
                                    if(arr[nextX][nextY]!=1){
                                        visited[nextX][nextY][nextState] = true;
                                        queue.add(new Node(nextX,nextY,nextState));
                                    }
                                }
                            }
                        }
                    }

                }
            }
            count++;
        }
        System.out.println(-1);

    }
    private static class Node{
        int x;
        int y;
        int state;

        public Node(int x, int y, int state){
            this.x =x;
            this.y = y;
            this.state = state;
        }
    }
}
