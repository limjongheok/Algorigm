import java.io.*;
import java.util.*;

class Main{
    public static long[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new long[116];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        if(n>=3){
            for(int i=3; i<n; i++){
                dp[i] = dp[i-1] + dp[i-3];
            }
        }
        System.out.println(dp[n-1]);



    }
}