import java.io.*;
import java.util.*;

class Main{
    private static int[] arr;
	    
	    private static int n;
	    private static int m;
	    private static int count=0;
	    private static boolean[] visited;
	
	    private static StringBuilder sb = new StringBuilder();
	    
	    
	    public static void main(String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st;
	        
	        n = Integer.parseInt(br.readLine());
	        m = Integer.parseInt(br.readLine());
	        
	        arr = new int[n];
	        visited = new boolean[n];
	  
	        st = new StringTokenizer(br.readLine());
	        for(int i=0; i<arr.length; i++){
	            arr[i] = Integer.parseInt(st.nextToken());
	        }
	       
	        
	        dfs(0,0,0);
	        System.out.println(count);
	    }
	    
	    private static void dfs(int start,int sum, int v){
	   
	    	
	     
	        
	        if(start == 2){
	        	if(sum == m){
		            count++;
		      
		            return ;
		        }
	            return;
	        }
	        for(int i=0; i<n; i++){
	        	if(arr[i] > v) {
	       
	        	sum = sum+arr[i];
                dfs(start+1,sum,arr[i]);
                sum = sum-arr[i];
             
	        }
	    }
	    }
}