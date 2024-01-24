import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        
        int[] arr =new int[n];
        
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int start = 0;
        int end = 0;
        int sum = arr[0];
        int max = sum;
        while(start <= end){
        	if(end == n-1){
        		if(sum >0) {
        			break;
        		}
                if(start == n-1) {
                	break;
                }
            }
        	
            if(sum > 0){
                end = end +1;
                sum += arr[end];
               
            }else{
            	 if(start == end){
                     start = start +1;
                     end =end +1;
                    
                     sum = arr[start];
                 }else {
                	  sum -= arr[start];
                      start = start +1;
                	 
                 }
              
            }
            if(max < sum){
                max = sum;
            }
       	 
            
        }
        
        System.out.println(max);
    }


}