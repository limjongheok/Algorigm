import java.io.*;
import java.util.*;


public class Main{
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int sum = 0;
        int max = 0;
        for(int i=0; i<k; i++){
            sum += arr[i];
        }
        max = sum;
        
        for(int i=1; i<=n-k; i++){
            sum = sum - arr[i-1] + arr[i+k-1];
            if(max < sum){
                max = sum;
            }
        }
        System.out.println(max);
    }
}