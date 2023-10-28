import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static  int[][] graph;
    private static boolean[] visit;
    private static  BufferedReader br;
    private static StringTokenizer st;
    private  static  int n;
    private  static  int m;

    private static  StringBuilder sb;

   public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));


        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        graph = new int[n+1][n+1];

        putGraph(n,m);
        visit = new boolean[n+1];
        sb = new StringBuilder();
        dfs(k);
        System.out.println(sb);


        visit = new boolean[n+1];
        sb = new StringBuilder();
        bfs(k);
        System.out.println(sb);





    }

    // 인접 행렬로 그래프 생성
    public static void putGraph(int n, int m) throws IOException {

        for(int i=1; i<=m; i++){

            st = new StringTokenizer(br.readLine());

            int firstNode = Integer.parseInt(st.nextToken());
            int secondNode = Integer.parseInt(st.nextToken());

            graph[firstNode][secondNode] = 1;
            graph[secondNode][firstNode] = 1;

        }
    }

    public static void dfs(int k){

        visit[k] = true;

        sb.append(k + " ");

        for(int i=0; i<=n; i++){
            if(graph[k][i] ==1 && !visit[i]){
                dfs(i);
            }
        }

    }

    public static void bfs(int k){
        visit[k] = true;

        Queue<Integer> queue = new LinkedList();
        queue.offer(k);

        while(!queue.isEmpty()){
            int st = queue.poll();
            sb.append(st + " ");
            for(int i=0; i<=n; i++){
                if(graph[st][i]== 1 && !visit[i]){
                    queue.add(i);
                    visit[i] = true;
                }
            }
        }
    }
}