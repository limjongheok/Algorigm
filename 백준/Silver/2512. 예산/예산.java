import java.io.*;
import java.util.*;


class Main{
    private static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        int end = 0;
        int start = 0;
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i]>end){
                end = arr[i];
            }
        }
        int m = Integer.parseInt(br.readLine());
        int mid = 0;
        while(start <= end){
             mid = (start+end)/2;
            int b = 0;
            //System.out.println(start +" " + end + " "+mid);

            for(int i=0; i<n; i++){
                if(arr[i]>mid){ b += mid;}
                else{
                    b+=arr[i];
                }
            }
            if(b<=m){
                start = mid +1;
            }else{
                end = mid-1;
            }
        }
        System.out.println(end);

    }
}