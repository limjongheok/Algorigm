import java.io.*;
import java.util.*;
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        
        long n = Long.parseLong(st.nextToken());
        long n2 = Long.parseLong(st.nextToken());
        
       
       System.out.print(Math.abs(n-n2));;
            
    }
}