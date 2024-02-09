import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    private static int[][][] arr;
    private static boolean[][][] visited;
    private static int n;
    private static  int m;
    private static  int h;

    private static int[] dx = {1,-1,0,0};
    private static int[] dy = {0,0,1,-1};
    private static int[] dz = {1,-1};
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h= Integer.parseInt(st.nextToken());

        arr = new int[h][n][m]; // 토마토 배열 판

        // 1. 토마토 배열 입력
        for(int i=0; i<h; i++){
            for(int j=0; j<n; j++){
                st =new StringTokenizer(br.readLine());
                for(int k=0; k<m; k++){
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        // 3. 익은 토마토 찾기
        for(int i=0; i<h; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<m; k++){
                    if(arr[i][j][k] == 1){
                        visited = new boolean[h][n][m];
                        bfs(i,j,k); // 익은 토마토 탐색
                    }
                }
            }
        }

        // 다 찾은후 가장 큰 값 구하기 허나 0 존재시 -1 출력
        boolean check = true;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<h; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<m; k++){
                    if(arr[i][j][k] == 0){
                        check = false;
                       break;
                    }
                    else{
                        max = Math.max(max, arr[i][j][k]);
                    }

                }
            }
        }

        if(check ){
            System.out.println(max-1);
        }else{
            System.out.println(-1);
        }


    }

    private static void bfs(int z, int x, int y){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(z,x,y));

        while(!queue.isEmpty()){
            Node nowNode = queue.poll();
            int nowZ = nowNode.z;
            int nowX = nowNode.x;
            int nowY = nowNode.y;
            // 다음 노드 탐색
            // 상하 좌우 탐색
            for(int i=0; i<4; i++){
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if(nextX >=0 && nextX<n){
                    if(nextY >= 0 && nextY <m){
                        if(!visited[nowZ][nextX][nextY]) {
                            if (arr[nowZ][nextX][nextY] != 1 && arr[nowZ][nextX][nextY] != -1) {
                                visited[nowZ][nextX][nextY] = true;
                                if (arr[nowZ][nextX][nextY] == 0) {
                                    // 다음 좌표가 0 이면
                                    arr[nowZ][nextX][nextY] = arr[nowZ][nowX][nowY] + 1; // 이전좌표 +1
                                    queue.add(new Node(nowZ, nextX, nextY)); // 다음 좌표 탐색
                                } else {
                                    if(arr[nowZ][nowX][nowY]+1 < arr[nowZ][nextX][nextY]){
                                        arr[nowZ][nextX][nextY] =  arr[nowZ][nowX][nowY] + 1; // 현재와 이전 좌표+1 한거
                                        queue.add(new Node(nowZ, nextX, nextY)); // 다음 좌표 탐색
                                    }
                                }
                            }
                        }

                    }
                }
            }

            // 위칸 아래칸 탐색
            for(int i=0; i<2; i++){
                int nextZ = nowZ +dz[i];
                if(nextZ >=0 && nextZ <h){
                    if(!visited[nextZ][nowX][nowY]) {
                        if (arr[nextZ][nowX][nowY] != 1 && arr[nextZ][nowX][nowY] != -1) {
                            visited[nextZ][nowX][nowY] = true;
                            if (arr[nextZ][nowX][nowY] == 0) { // 다음 노드가 0 이면
                                arr[nextZ][nowX][nowY] = arr[nowZ][nowX][nowY] + 1;
                                queue.add(new Node(nextZ, nowX, nowY)); // 다음 노드 탐색
                            } else {
                                if(arr[nowZ][nowX][nowY]+1 <arr[nextZ][nowX][nowY]){
                                    arr[nextZ][nowX][nowY] = (arr[nowZ][nowX][nowY] + 1); // 현재와 이전 좌표+1 한거
                                    queue.add(new Node(nextZ, nowX, nowY)); // 다음 좌표 탐색
                                }

                            }
                        }
                    }

                }
            }


        }
    }
}
class Node{
    int z;
    int x;
    int y;
    public Node(int z, int x, int y){
        this.z =z;
        this.x = x;
        this.y = y;
    }
}

