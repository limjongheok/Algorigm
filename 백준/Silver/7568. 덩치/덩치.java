import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        int n = Integer.parseInt(br.readLine());
        
        int[] weigh = new int[n];
        int[] heigh = new int[n];
        int[] o = new int[n];
 
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            heigh[i] = h;
            weigh[i] = w;
            o[i] = 1;
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(weigh[i] <weigh[j] && heigh[i] < heigh[j]){
                    o[i] ++;
                }
            }
        }
        
        for(int i=0; i<n; i++){
            System.out.print(o[i] + " ");
        }
 
    }
}