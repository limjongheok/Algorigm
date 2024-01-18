import java.io.*;
import java.util.*;

class Main{
  private static int[] arr;
    
    private static int n;
    private static int x;
    private static int max = Integer.MIN_VALUE;
    private static int count =1;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        
        arr = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int sum = 0;
        for(int i=0; i<x; i++) {
        	sum += arr[i];
        }
        
        max = sum;
        
        for(int i=1; i<n-(x-1); i++) {
        	sum = sum +arr[i+x-1] -arr[i-1];
   
        	if(max < sum) {
        	
        		max = sum;
        		count=1;
        	}else {
        		if(max == sum) {
        			count++;
        		}
        	}
        }
        
        if(max != 0) {
        	System.out.println(max);
        	System.out.println(count);
        }else {
        	System.out.println("SAD");
        }
        
        
        
       
        
    }
   
}