import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int[][] arr;
    private static int[][] copyArr;
    private static boolean[][] visited;
    private static int n;
    private static int m;

    private static int[] dx = {1,-1,0,0};
    private static int[] dy = {0,0,1,-1};

    private static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        arr = new int[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        } // 1. 배열 입력

        dfs(0);
        System.out.println(max);
    }

    private static void dfs(int wall){
        if(wall == 3){ // 벽이 3개일때
            visited = new boolean[n][m];
            copyArr = new int[n][m];

            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    copyArr[i][j] = arr[i][j];
                }
            }

            for(int i=0; i<n; i++){ // 감염 시키기
                for(int j=0; j<m; j++){
                    if(copyArr[i][j] == 2){
                        if(!visited[i][j]){
                            bfs(i,j); // 모든 노드 2 를 만들기
                        }
                    }
                }
            }

            // 안전 지대 찾기
            int count = 0;
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(copyArr[i][j] == 0){
                        count++;
                    }
                }
            }
            max = Math.max(max,count);
            return;
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j] == 0){ // 빈벽일시
                    arr[i][j] = 1; // 벽 세우기
                    dfs(wall+1);
                    arr[i][j] = 0;
                }
            }
        }

    }

    private static void bfs(int x, int y){ // 다음 노드 감염 시키기
        visited[x][y] = true;
        Queue<Nodes> queue  = new LinkedList();
        queue.add(new Nodes(x,y));
        while (!queue.isEmpty()){
            Nodes nowNode = queue.poll();
            int nowX = nowNode.x;
            int nowY = nowNode.y;

            // 다음 노드 가능 여부 및 탐색
            for(int i=0; i<4; i++){
                int nextX = nowX+dx[i];
                int nextY = nowY +dy[i];

                if(nextX >=0 && nextX <n){
                    if(nextY>=0 && nextY<m){
                        if(copyArr[nextX][nextY]==0){
                            if(!visited[nextX][nextY]){
                                visited[nextX][nextY] = true; // 다음 노드 방무
                                copyArr[nextX][nextY] = 2; // 다음 노드 감염
                                queue.add(new Nodes(nextX,nextY)); // 다음 노드 탐색
                            }
                        }
                    }
                }
            }
        }

    }
    
}
class Nodes{
    int x;
    int y;
    public Nodes(int x, int y){
        this.x = x;
        this.y = y;
    }
}
