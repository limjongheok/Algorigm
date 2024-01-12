import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sb;
        
        sb = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(sb.nextToken());
        int k = Integer.parseInt(sb.nextToken());
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        int count = 0;
        for(int i=n-1; i>=0; i--){
            if(arr[i] <= k){
                count += k/arr[i] ;
                k= k%arr[i]; // 200
            }
        }
        
        System.out.println(count);
        
        
    }
}