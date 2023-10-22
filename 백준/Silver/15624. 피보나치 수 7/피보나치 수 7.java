import java.io.*;
import java.util.*;

class Main{
    static long[] num;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        num = new long[1000001];
        num[0] = 0;
        num[1] = 1;
        for(int i=2; i<=n; i++){
            num[i] = (num[i-1]+num[i-2]) %1000000007;

        }
        System.out.println(num[n]);


    }
}