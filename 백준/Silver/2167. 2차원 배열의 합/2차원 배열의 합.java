import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n+1][m+1];

        for(int i=1; i<n+1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<m+1; j++){
                arr[i][j] = arr[i][j-1]+ Integer.parseInt(st.nextToken());
            }
        }

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<t; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int sum = 0;
            for(int j=x1; j<=x2; j++){
                sum += arr[j][y2] - arr[j][y1-1];

            }
            sb.append(sum);
            sb.append("\n");
        }
        System.out.println(sb);




    }
}