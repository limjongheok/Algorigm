import java.io.*;
import java.util.*;

class Main{
     private static int[] arr;
	 private static boolean[] visited;
	   
	    public static void main(String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st;
	        
	        int n = Integer.parseInt(br.readLine());
	        
	        arr = new int[n];
	        visited = new boolean[n];
	        
	        st = new StringTokenizer(br.readLine());
	        for(int i=0; i<n; i++){
	            arr[i] = Integer.parseInt(st.nextToken());
	        }
	        
	        Arrays.sort(arr);
	        
	       
	        int count= 0;
	        for(int i=0; i<n; i++) {
	        	int start = 0;
	 	        int end = n-1;
	 	   
	 	       
	 	        int target = arr[i];
	        	while(start < end){
	        		
		        	// 두 수 
	        		int sum = arr[start] + arr[end];
	        		
	        		if(sum > target) { // 타깃 보다 크면 
	        			end = end -1;
	        		}else if(sum <target ) {
	        			start = start +1;
	        		}else { // start == target
	        			if(i != start && i!= end) {
	        				count++;
		        			break;
	        			}else if(i==start) {
	        				start = start +1;
	        			}else {
	        				end = end-1;
	        			} // 0 0 0 0 1
	        			
	        			
	        		}
	        		
	        		}
	        		
	        }
	        
	    
	        
	    
	    System.out.println(count);
	    }
    
    
}