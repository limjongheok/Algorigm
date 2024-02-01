import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
   private static  int n;
    private static int[] arr1;
    private  static  int[] arr2;
    private static boolean[] visited;
    private static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        arr1 = new int[n];
        arr2 = new int[n];
        visited = new boolean[n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());
            arr1[i] = one;
            arr2[i] = two;
        }

        for(int i=0; i<n; i++){
            re(i,1,0);
        }

        System.out.println(min);
    }

    private static void re(int start, int s, int b){

        if(start == n){
            int r = Math.abs(s-b);
            if(r <min){
                min = r;
            }
            return;
        }


        for(int i=0; i<n; i++){
            if(!visited[i]){
                visited[i] =true;
                re(start+1,arr1[i]*s,b+arr2[i]);
                visited[i] = false;
            }
        }


    }
}