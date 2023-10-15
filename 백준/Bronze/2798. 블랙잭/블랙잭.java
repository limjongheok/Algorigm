import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] num = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        //4
        //3     2    1
        //2 1 0 1 0   0

        int min = Math.abs(21-(num[0]+num[1]+num[2]));
        int sum = num[0]+num[1]+num[2];
        for(int i=n-1; i>=2; i--){
            for(int j=i-1; j>=1; j--){
                for(int k=j-1; k>=0; k--){


                    if(min >Math.abs(m- (num[i] + num[j] + num[k]))&& (num[i]+num[j]+num[k])<=m){

                        sum = num[i] + num[j] + num[k];
                        min = Math.abs(m-sum);
                    }

                }
            }
        }
        System.out.println(sum);
    }
}