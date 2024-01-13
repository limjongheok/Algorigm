import java.io.*;
import java.util.*;

class Main{
    private static int[] arr;
    private static int n;
    private static int m;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(duple(0,0));


    }

    private static int duple(int len, int sum){
        if(len == n){
            return sum;
        }

        int totalSum = 0;
        for(int i=len; i<n; i++){
            totalSum += arr[i];
            if(totalSum == m){
                sum++;
                break;
            }
        }


        return duple(len=len+1,sum);
    }

}