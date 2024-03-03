import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr ;
    static int[] dx = {0,1,1}; // 좌 하 대
    static int[] dy = {1,0,1};
    static  int n;
    static Queue<Node> queue;
    static  int count;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        // 시작점 0,1

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        count = 0;
        if(arr[n-1][n-1] ==1) {
            System.out.println(count);
        }else{
            bfs(0,1);

            System.out.println(count);
        }
   
    }
    private static void bfs(int x, int y){
        queue = new LinkedList<>();
         queue.add(new Node(x,y,1));


        while (!queue.isEmpty()){
            int size = queue.size();


            for(int i=0; i<size; i++){ // 레벨별 bfs
                Node node = queue.poll();
                int nowX = node.x;
                int nowY = node.y;
                int nowDir =node.dir;

                if(nowX == n-1 && nowY == n-1){
                    count ++; // 경우 수 구하기
                }

                if(nowDir == 1){
                    left(nowX, nowY);
                    diagonal(nowX, nowY);
                }
                if(nowDir ==2){
                    // 세로
                    down(nowX, nowY);
                    diagonal(nowX, nowY);
                }
                if(nowDir == 3){
                    down(nowX, nowY);
                    left(nowX, nowY);
                    diagonal(nowX, nowY);
                }
            }
        }
    }
    private static void left(int nowX, int nowY){
        int nextY = nowY +dy[0];
        int nextX = nowX;


        if(nextY >=0 && nextY <n){
            if(arr[nowX][nextY] == 0){
                queue.add(new Node(nextX,nextY,1));
            }
        }
    }
    private static void down(int nowX, int nowY){
        int nextX = nowX +dx[1];
        int nextY = nowY;
        if(nextX >=0 && nextX <n){
            if(arr[nextX][nextY] == 0){
                queue.add(new Node(nextX,nextY,2));
            }
        }
    }

    private static void diagonal(int nowX, int nowY){
        int nextX = nowX +dx[2];
        int nextY = nowY + dy[2];
        if(nextX >=0 && nextX <n){
            if(nextY >=0 && nextY <n){
                if(arr[nextX][nextY] == 0){
                    if(arr[nextX][nextY-1] != 0 ) return;
                    if(arr[nextX-1][nextY] !=0 ) return;
                    queue.add(new Node(nextX,nextY,3));
                }
            }
        }
    }

    private static class  Node{
        int x;
        int y;
        int dir; // 1 가로 //2 세로 // 3 대각선
        public  Node(int x, int y, int dir){
            this.x =x;
            this.y = y;
            this.dir = dir;
        }

    }
}
