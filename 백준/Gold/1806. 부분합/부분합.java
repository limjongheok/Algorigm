import java.io.*;
import java.util.*;

class Main{
      private static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int start = 0;
        int end = 0;
        int sum  = arr[0];
        int min = Integer.MAX_VALUE;


        while(true){

                if(sum<s){
                    // end 이동
                    end = end+1;
                    sum += arr[end];
                }else if(sum >= s){
                    //start 이동
                    int length = end - start + 1;
                    if (min > length) {
                        min = length;
                    }
                    sum -= arr[start];
                    start = start +1;
                }
                if(end ==n-1){
                    if(sum < s){
                        break;
                    }

                }
        }

        if(min != Integer.MAX_VALUE){
            System.out.println(min);
        }else{
            System.out.println(0);
        }




    }
}