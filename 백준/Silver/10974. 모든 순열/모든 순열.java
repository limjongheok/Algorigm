import java.io.*;
import java.util.*;
public class Main {
    private static   int[] graph;
    private  static  boolean[] visited;

    private  static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine()); //3

        graph = new int[n];
        visited = new boolean[n];

        dfs(0);
    }

    private  static void dfs(int cnt){

        if(cnt == n){
            for(int i=0; i<n; i++){
                System.out.print(graph[i] + " ");
            }
            System.out.println();
            return ;
        }

        for(int i=0; i<n; i++){
            if(!visited[i]){
                graph[cnt] = i+1;
                visited[i] = true;
                dfs(cnt+1);
                visited[i] = false;
            }
        }

    }
}
