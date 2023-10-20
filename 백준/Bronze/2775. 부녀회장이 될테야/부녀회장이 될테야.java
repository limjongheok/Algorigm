import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int i=0; i<T; i++){
            int a = Integer.parseInt(br.readLine());
            int b = Integer.parseInt(br.readLine());
            
     
            System.out.println(sol(a,b));
            
            
        }
    }
    public static int sol(int a,int b){
        if(b ==0){
            return 0;
        }else if(a==0){
            return b;
        }else{
            return sol(a,b-1) + sol(a-1,b);
        }
        
        
       
    }
}