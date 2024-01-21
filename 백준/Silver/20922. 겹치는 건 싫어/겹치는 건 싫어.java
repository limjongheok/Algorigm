import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int[] check = new int[100001];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int max = 0;

        while(true){
            if(end == n){
                break;
            }
        

            int len = end -start;
            int now = arr[end];

            if(check[now] < k){
                check[now] += 1;

                if(max < len){
                    max = len;
                }
                end = end +1;

            }else if(check[now] >= k){
                int sPoint = arr[start];
                check[sPoint] -= 1;
                start = start +1;
            }
        }
        if(n== 0){
            System.out.println(0);
        }else{
            System.out.println(max+1);
        }
    }
}