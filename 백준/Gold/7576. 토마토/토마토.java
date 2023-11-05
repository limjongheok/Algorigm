import java.io.*;
import java.util.*;
public class Main {
    private static int n;
    private static int m;
    private  static int[][] graph;
    private  static boolean[][] visited;
    private  static int[] dx ={0,0,1,-1};
    private  static  int[] dy = {1,-1,0,0};
    private static int count =0;
    private static  Queue<dot> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[m][n];
        visited = new boolean[m][n];

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
               graph[i][j] = Integer.parseInt(st.nextToken());
               if(graph[i][j] ==1){
                   dot dot = new dot(i,j);
                   queue.add(dot);
               }
            }
        }



        bfs();

        boolean b = false;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(graph[i][j] == 0){
                    b = true;
                }
            }
        }

        if(b){
            System.out.println(-1);
        }else{
            if(count ==0){
                System.out.println(0);
            }else{
                System.out.println(count-1);
            }
            
        }




    }
    private static void bfs(){

        while(!queue.isEmpty()){


            dot nowd = queue.poll();
            int nowx = nowd.x;
            int nowy = nowd.y;
            boolean c= false;

            for(int i=0; i<4; i++){
                int nextX = nowx +dx[i];
                int nextY = nowy + dy[i];

                if(nextX >=0 && nextX<m){
                    if(nextY>=0 && nextY<n){
                        if(graph[nextX][nextY] ==0 && !visited[nextX][nextY]){
                            graph[nextX][nextY] =graph[nowx][nowy] +1;
                            visited[nextX][nextY] = true;
                            count = graph[nextX][nextY];

                            dot nextDot =  new dot(nextX,nextY);
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
