import java.util.*;
import java.io.*;

class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st ;
        int n = Integer.parseInt(br.readLine());
        
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
        
            
            System.out.println("Case #"+i+":"+" "+a+" + "+b+" = "+(a+b));
            
        }
        
        
    }
}