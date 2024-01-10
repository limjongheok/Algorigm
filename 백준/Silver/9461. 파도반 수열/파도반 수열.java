import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int tc = Integer.parseInt(br.readLine());
        
        for(int t=0; t<tc; t++){
            int n = Integer.parseInt(br.readLine());
            long[] dp = new long[100];
            
            dp[0] = 1;
            dp[1] = 1;
            dp[2] = 1;
            for(int i=3; i<n; i++) {
            	dp[i] = dp[i-3] + dp[i-2];
            	
            }
           System.out.println(dp[n-1]);
        }
        
    }

}