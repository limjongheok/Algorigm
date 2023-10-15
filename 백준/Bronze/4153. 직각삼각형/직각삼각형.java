import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String s ="";
        
        while(!(s=br.readLine()).equals("0 0 0")){
            st = new StringTokenizer(s);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            int[] t = new int[3];
            t[0] = a*a;
            t[1] = b*b;
            t[2] = c*c;
            
            int max = t[0];
            for(int i=0; i<3; i++){
               if(max <t[i]){
                   max = t[i];
               }
            }
            boolean tr = false;
            if(max== t[0]){
                if(t[0]== t[1]+t[2]){
                    tr = true;
                }
            }else if(max == t[1]){
                if(t[1] == t[0]+t[2]){
                    tr = true;
                }
            }else{
                if(t[2] == t[0]+t[1]){
                    tr = true;
                }
            }
            
            if(tr){
                System.out.println("right");
            }else{
                System.out.println("wrong");
            }
        }
    }
}