import java.io.*;
import java.util.*;

class Main{
    public static long[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new long[36];

        dp[0] =1;
        dp[1] =1;

        for(int i=2; i<36; i++){
            for(int j=0; j<i; j++){
                dp[i] += (dp[j]* dp[i-1-j]);

            }

        }

        System.out.println(dp[n]);

    }
}