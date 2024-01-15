import java.io.*;
import java.util.*;

class Main{
    private static int[] arr;
    
    
    private static int n;
    private static int m;
    private static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        arr = new int[m];
        
        
        
        dfs(0, 0);
        System.out.println(sb);
       
    }
    
    private static void dfs(int start, int v){
        if(start == m){
            for(int i : arr){
                sb.append(i + " ");
            }
            sb.append("\n");
            return ;
        }
        for(int i=0; i<n; i++){
            if(i>=v){
               
              
                arr[start] = i+1;
                dfs(start+1,i); // 현재 i 값 보냄
                
                
            }
            
        }
        
    }
}