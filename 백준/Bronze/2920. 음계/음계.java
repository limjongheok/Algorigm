import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
       
        boolean t = true;
        
        int n = Integer.parseInt(st.nextToken()); // 8 혹은 1 
        if(n==1){
            for(int i=2; i<=8; i++){
                if(i != Integer.parseInt(st.nextToken())){
                    t = false;
                }
            }
            
        }else{ // n ==8
            for(int i=7; i>0; i--){
                if(i != Integer.parseInt(st.nextToken())){
                    t = false;
                }
            }
            
            
        }
        if(t){
            if(n==1){
                System.out.println("ascending");
            }else{
               System.out.println("descending"); 
            }
        }else{
             System.out.println("mixed");
        }
        
      
        
       
    }
}