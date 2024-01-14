import java.util.*;
import java.io.*;

public class Main {
    private static int[] arr;
    private static int n;
    private static int m;
    private static boolean[]visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        visited = new boolean[n];



        dfs(0);

    }

    private static void dfs(int start){


        if(start==m){
            for(int i : arr){
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for(int i=0; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[start] = i +1 ;
                dfs(start+1);
                visited[i] = false;
            }
        }

    }


}
