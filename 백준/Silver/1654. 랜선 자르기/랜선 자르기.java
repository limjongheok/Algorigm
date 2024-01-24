import java.io.*;
import java.util.*;

class Main{
   private static StringBuilder sb = new StringBuilder();
    public static  void main(String[] args) throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] arr = new long[n];

        long start =1;
        long end = 0;
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
            if(end < arr[i]){
                end = arr[i];
            }
        }
        end ++;

        while(start < end){
            long mid = (start + end) /2;

            long sum = 0;
            for(int i=0; i<n; i++){
                sum += (arr[i] / mid);
            }
            // 최대 랜선
            if(sum < m){
                end = mid;
            }else{
                start = mid +1;
            }
        }
        System.out.println(end-1);

    }
}