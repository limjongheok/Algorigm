import java.io.*;
import java.util.*;

class Main{
    	private static int n;
    private static int m;
    private static int[] arr;
    private static int[] map;
    private static boolean[] visited;
    private static int[] check;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        arr = new int[n];
        visited = new boolean[n];
        map = new int[m];
        check = new int[1];
          
        st = new StringTokenizer(br.readLine());
        
        
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        
        dfs(0,0);
        System.out.println(sb);
        
    }
    
    public static void dfs(int start, int r){
        
        if(start == m){
            for(int a : map){
                sb.append(a+" ");
            }
            sb.append("\n");
            return;
            
        }
       
        int before = 0;
        for(int i=0; i<n; i++){
        
            if(!visited[i]){
            	if(before != arr[i]) {
            		
            		 visited[i] = true;
                     map[start] = arr[i];
                     before = arr[i];
                     dfs(start + 1, arr[i]);
                     visited[i] = false;
            		
            	}    
              
            }
            
        }
    }

}