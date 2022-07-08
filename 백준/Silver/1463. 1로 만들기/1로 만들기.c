#include <stdio.h>
#include <stdlib.h>

int main()
{
    int n;
    int dp[10000001];
    scanf("%d",&n);
    dp[1]=0;
    for(int i=2; i<=n; i++){
        dp[i]=dp[i-1]+1;
        if(i%2==0){
            if(dp[i]>dp[i/2]+1){
                dp[i]=dp[i/2]+1;
            }

        }
        if(i%3==0){
            if(dp[i]>dp[i/3]+1){
                dp[i]=dp[i/3]+1;
            }
        }
    }
    printf("%d",dp[n]);
}
