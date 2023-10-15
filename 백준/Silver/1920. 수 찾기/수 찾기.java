import java.io.*;
import java.util.*;

class Main{
    static int[] numA;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        numA = new int[n];
        
       
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            numA[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(numA);
        
        int n2 = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n2; i++){
            int key = Integer.parseInt(st.nextToken());
            int high = n-1;
            int low = 0;
            
            System.out.println(binary(key,low,high));
            
        }
        
    }
    
    public static int binary(int key, int low, int high){
        int mid;
        if(low<=high){
            mid = (low+high)/2;
            
            if(numA[mid] == key){
                return 1;
            }else if(key<numA[mid]){
                return binary(key,low,mid-1);
            }else{
                return binary(key,mid+1,high);
            }
        }
        
        return 0;
    }
}