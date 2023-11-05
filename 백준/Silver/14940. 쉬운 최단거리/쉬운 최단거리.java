import java.io.*;
import java.util.*;

public class Main {
    private  static int[] dx = {0,0,1,-1};
    private  static int[] dy = {1,-1,0,0};

    private  static  int[][] graph ;
    private static  boolean[][] visited;

    private static   int n;
    private  static  int m;

    public static  void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        visited = new boolean[n][m];


        dot dotg = null;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j] ==2){
                    dotg = new dot(i,j);
                }

            }
        }
        bfs(dotg);

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!visited[i][j] && graph[i][j] ==1){
                    System.out.print(-1 + " ");
                }else{
                    System.out.print(graph[i][j] + " ");
                }
            }
            System.out.println();
        }

    }
    private static void bfs(dot dot){
        int x = dot.x;
        int y = dot.y;
        visited[x][y] = true;
        graph[x][y] = 0;

        Queue<dot> queue = new LinkedList<>();
        queue.add(dot);

        while(!queue.isEmpty()){
            dot nowDot = queue.poll();
            int nowX = nowDot.x;
            int nowY = nowDot.y;

            for(int i=0; i<4; i++){
                int nextX = nowX+dx[i];
                int nextY = nowY+dy[i];

                if(nextX>=0 && nextX< n){
                    if(nextY>=0 && nextY<m){
                        if(graph[nextX][nextY]==1 && !visited[nextX][nextY]){
                            visited[nextX][nextY] = true;
                            graph[nextX][nextY] = graph[nowX][nowY] +1;
                            dot nextDot = new dot(nextX,nextY);
                            queue.add(nextDot);
                        } else if (graph[nextX][nextY] == 0 &&!visited[nextX][nextY]){
                            visited[nextX][nextY] = true;
                        }
                    }
                }
            }
        }
    }
}

class dot{
    int x;
    int y;

    public dot(int x, int y){
        this.x=x;
        this.y = y;
    }
}
