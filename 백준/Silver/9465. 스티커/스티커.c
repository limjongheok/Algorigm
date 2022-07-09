#include <stdio.h>
#include <stdlib.h>
int max(int a,int b){
    return a>b?a:b;
}
int main()
{
    int n;
    scanf("%d",&n);
    int m;

    int dp[2][100001] ;
    int sp[2][100001];
    int b;
    int h=0;
    while(h<n){
            scanf("%d",&m);
        for (int i=0; i<=1; i++){
            for (int j=0; j<m; j++){
                scanf("%d",&b);
                sp[i][j]=b;
            }
        }


        dp[0][0]=sp[0][0];
        dp[0][1]=sp[1][0]+sp[0][1];
        dp[1][0]=sp[1][0];
        dp[1][1]=sp[0][0]+sp[1][1];

        for(int j=2; j<m; j++){
            dp[0][j]=max(dp[1][j-1],dp[1][j-2])+sp[0][j];
            dp[1][j]=max(dp[0][j-1],dp[0][j-2])+sp[1][j];
        }

        int r= max(dp[0][m-1],dp[1][m-1]);
        printf("%d\n",r);
        h++;




    }







}
