import java.io.*;
import java.util.*;
class Main{
    public static void main(String[] arsg) throws IOException{
        Deque<Integer> dq = new ArrayDeque();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        for(int i=1; i<=n; i++){
            dq.add(i);
        }
        while(dq.size() !=1){
            dq.remove();
            int n2 = dq.remove();
            dq.add(n2);
        }
        System.out.println(dq.getFirst());
        
        
    }
}