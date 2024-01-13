import java.io.*;
import java.util.*;

class Main{
    
    private static int[] arr;
    private static int n;
    private static int s;
    private static  int count;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        count = 0;
        duple(0,0);
        if(s == 0) {
            System.out.println(count-1);
        }else {
            System.out.println(count);
        }


    }

    private static void duple(int start, int totalSum){
        if(start == n){
            if(totalSum == s){
                count++;
            }
            return;
        }

        duple(start+1, totalSum+arr[start]);
        duple(start+1,totalSum);

    }
}