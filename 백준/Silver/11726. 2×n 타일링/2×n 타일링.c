#include <stdio.h>
#include <stdlib.h>

int main()
{
    int n;
    scanf("%d",&n);
    int a[1001];
    a[1]=1;
    a[2]=2;
    for (int i=3; i<=n; i++){
        a[i]=(a[i-1]+a[i-2])%10007;
    }

    printf("%d",a[n]);


}
