import java.util.*;
import java.io.*;

public class Main {
    private static int n;
    private static  int m;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
         n = Integer.parseInt(st.nextToken());
         m = Integer.parseInt(st.nextToken());

         visited = new boolean[n];
         int[] arr = new int[m];

        re(0, arr);
    }

    private static void re(int idx, int[] arr){
        if(idx == m){
            StringBuilder sb = new StringBuilder();
            for(int i: arr){
                sb.append(i+ " ");
            }
            System.out.println(sb);
            return;
        }

        for(int i=0; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[idx] = i+1;
                re(idx+1,arr);
                visited[i] = false;
            }
        }
    }

}
