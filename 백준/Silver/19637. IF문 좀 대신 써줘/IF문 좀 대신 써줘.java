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
        String[] sArr = new String[n];
        int[] arr= new int[n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            Integer a = Integer.parseInt(st.nextToken());
            sArr[i] = s;
            arr[i] = a;
        }

        for(int i=0; i<m; i++){
            int num = Integer.parseInt(br.readLine());

            int start = 0;
            int end = n-1;
            while(start< end){
                int mid = (start + end) / 2;


                if(num <= arr[mid]){
                    end = mid;
                }else{
                    start = mid+1;
                }
            }
            sb.append(sArr[end]).append("\n");
        }
        System.out.println(sb);
    }
}