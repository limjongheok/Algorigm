import java.io.*;
import java.util.*;

class Main{
    
     public static int dp[][];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tk = Integer.parseInt(br.readLine());

        for(int i=0; i<tk; i++){
            int n = Integer.parseInt(br.readLine());
            dp = new int[n+1][2];
            if(n ==1){
                System.out.println(0 + " "+ 1);

            }else if(n==0){
                System.out.println(1 + " "+ 0);
            }else{
                dp[0][0] = 1;
                dp[0][1] = 0;
                dp[1][0] =0;
                dp[1][1] = 1;

                for(int j=2; j<=n; j++){
                    dp[j][0] = dp[j-1][0] +dp[j-2][0];
                    dp[j][1] = dp[j-1][1] +dp[j-2][1];
                }
                System.out.println(dp[n][0] + " "+ dp[n][1]);
            }


        }

    }
}