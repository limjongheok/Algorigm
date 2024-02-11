import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Long input = Long.parseLong(br.readLine());

        int n = (int)(input % 1500000);

        int[] dp = new int[n+1];

        dp[0] = 0;
        dp[1] = 1;

        for(int i=2; i<=n; i++){
            dp[i] = (dp[i-1]+dp[i-2])%1000000;
        }
        System.out.println(dp[n]);

    }
}