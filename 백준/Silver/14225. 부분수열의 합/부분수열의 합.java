import java.io.*;
import java.util.*;
public class Main {
    private static  int[] graph;
    private static boolean[] isUse;
    private  static  int n;
    public static  void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        isUse = new boolean[100000*20 + 1];
        graph = new int[n];
        for(int i=0; i<n; i++){
            graph[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        for(int i=1; i<isUse.length; i++){

            if(!isUse[i]){
                System.out.println(i);
                break;
            }
        }
    }

    private  static  void dfs(int deep, int sum){
        if(deep == n){
            isUse[sum] = true;
            return;
        }

        dfs(deep+1 , sum + graph[deep]);
        dfs(deep+1, sum);
    }

}
