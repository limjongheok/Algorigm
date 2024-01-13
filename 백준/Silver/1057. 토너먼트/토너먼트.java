import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int kim = Integer.parseInt(st.nextToken());
        int lim = Integer.parseInt(st.nextToken());
        
        System.out.println(division(lim,kim,0));
        
    }
    
     private static int division(int x, int y , int sum){
        if(x==y){
            return sum;
        }
        
        return division(x/2+x%2,y/2+y%2,sum=sum+1);
    }
    
   
}