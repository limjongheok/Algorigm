import java.io.*;
import java.util.*;

class Main{
    private static int[] arr;
    private static boolean[] visited;
    private static int n;
    private static int m;
    private static StringBuilder sb = new StringBuilder();;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        arr = new int[m];
        visited = new boolean[n];
     
        dfs(0);
        System.out.print(sb);
    }
    
    private static void dfs(int start){
        if(start == m){
           
            for(int i : arr){
                sb.append(i +" ");
                
            }
            sb.append('\n');
            return;
        }
        for(int i=0; i<n; i++){
            arr[start] = i+1;
            dfs(start+1);
        }
    }
}