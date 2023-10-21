import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        Queue<Integer>   q= new LinkedList();
        
        for(int i=1; i<=n; i++){
            q.add(i);
        }
        
        while(!q.isEmpty()){
            int a = q.poll();
            System.out.println(a);
            
            if(!q.isEmpty()){
                 int b = q.poll();
            q.add(b);
            
                
            }
           
        }
    }
}