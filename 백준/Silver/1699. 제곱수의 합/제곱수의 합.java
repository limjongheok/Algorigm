import java.util.Scanner;

public class Main {
    static int N;
    static  int[] dp;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dp= new int[N+1];
        for(int i=1; i<=N; i++){
            dp[i] = i;
            for(int j=1; j*j<=i; j++){
                if(dp[i]>dp[i-j*j]+1){ // 최소 값을 찾고 있으니까
                    dp[i] = dp[i-j*j]+1;
                }
            }

        }
        System.out.println(dp[N]);

    }
}
