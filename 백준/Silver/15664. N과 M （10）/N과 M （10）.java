import java.io.*;
import java.util.*;

class Main{
    private static int[] arr;
    private static boolean[] visited;
    private static int[] map;
    
    private static int n;
    private static int m;
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
        
        // 배열 채우기 
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        dfs(0,0);
        System.out.println(sb);
    }
    
    private static void dfs(int start, int v){
    	
        if(start == m){
            for(int i : map){
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }
        
        int check = 0;
        for(int i=0; i<n; i++){
            if(!visited[i]){
                // 나 방문 안하겠다는 소리 
                
                if(arr[i]!= check){
                     if(arr[i] >= v){
                    // 다음 노드가 나보다 작음 안되지 
                    visited[i] = true;
                    map[start] = arr[i];
                    check = arr[i];
                    dfs(start+1,arr[i]); // 현재 나를 넣어줌으로 다음 노드가 나보다 작지 않음을 체크 
                    visited[i] = false; 
                    }
                }
               
                
            }
        }
    }

}