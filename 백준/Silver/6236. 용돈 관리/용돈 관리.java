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

        int[] arr = new int[n];
        int end =0;
        int start = 0;
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
            if(arr[i] > start){
                start = arr[i];
            }
            end += arr[i];
        }

        while(start < end){
            int mid = (start+end)/2;
            int sum = 1;
            int a = mid;
            for(int i=0; i<n; i++){
                if(a<arr[i]){
                    sum ++;
                    a = mid;
                    a-= arr[i];
                }else{
                    a -= arr[i];
                }
            }

            if(sum <= m){
                end = mid;
            }else{
                start = mid+1;
            }
        }
        System.out.println(end);

    }
}