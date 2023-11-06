import java.io.*;
import java.util.*;

public class Main {

    private static  int[][] graph;
    private  static int[][] graph2;
    private  static  boolean[][] visited;

    private  static int n;

    private  static int count;

    private  static int[] dx ={0,0,1,-1};
    private  static int[] dy = {1,-1,0,0};
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];



        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                int num = Integer.parseInt(st.nextToken());
                graph[i][j] = num;

            }
        }

        int max = 1;

        for(int i=1; i<=100; i++){
            visited = new boolean[n][n];
            graph2 = new int[n][n];
            count = 0;
            int hNum = height(i);
            if(max < hNum){
                max = hNum;
            }
        }

        System.out.println(max);

    }
    // 높이별 땅 개수
    private  static int height(int h){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(graph[i][j]<=h){
                    graph2[i][j] = 1;
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j] && graph2[i][j] ==0){
                    count ++;
                    bfs(i,j);
                }
            }
        }
        return count;
    }

    private static void bfs(int x, int y){
        visited[x][y] = true;

        dot dot = new dot(x,y);
        Queue<dot> queue = new LinkedList<>();
        queue.add(dot);

        while(!queue.isEmpty()){
            dot nowDot = queue.poll();
            int nowX = nowDot.x;
            int nowY = nowDot.y;

            for(int i=0; i<4; i++){
                int nextX = nowX +dx[i];
                int nextY = nowY +dy[i];

                if(nextX>=0 && nextX<n){
                    if(nextY>=0 && nextY<n){
                        if(graph2[nextX][nextY] == 0 && !visited[nextX][nextY]){
                            visited[nextX][nextY] = true;
                            dot nextDot = new dot(nextX,nextY);
                            queue.add(nextDot);
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
