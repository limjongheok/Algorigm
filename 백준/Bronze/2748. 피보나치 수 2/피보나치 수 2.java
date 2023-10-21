import java.util.*;
import java.io.*;
class Main{
    public static long[] a;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        a = new long[n+1];




        for(int i = 0; i <  n+ 1; i++) {
            a[i] = -1;
        }
        a[0] = 0;
        a[1] = 1;

        System.out.println(dp(n));



    }
    public static long dp(int n){
        if(a[n] == -1){
            a[n] = dp(n-1) + dp(n-2);
        }
        return a[n];

    }
}