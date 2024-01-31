import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int m;
    private static int n;
    private static boolean[] visited; // 중복 체크
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         n = Integer.parseInt(st.nextToken());
         m = Integer.parseInt(st.nextToken());
         visited = new boolean[n];

        int[] arr = new int[m];
        re(0,arr,0);
        System.out.print(sb);
    }

    public static void re(int start, int[] arr, int pre){
        if(start == m){
            for(int i: arr){
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<n; i++){
            if(i>=pre){
                if(!visited[i]){
                    visited[i] = true;
                    arr[start] = i+1;
                    re(start+1,arr,i);
                    visited[i] =false;

                }
            }


        }
    }
}