import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    static  int N; // 정점
    static  int M; // 간선

    static  int[][] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 정점
        M = Integer.parseInt(st.nextToken()); // 간선
        array = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            Arrays.fill(array[i],5001);
            array[i][i] = 0;
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            array[a][b] = 1;
            array[b][a] = 1;
        }



        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    array[i][j] = Math.min(array[i][j], array[i][k] + array[k][j]);
                }
            }
        }

        int answer = -1;
        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            int sum = 0;
            for (int j = 1; j <= N; j++) {
                sum += array[i][j];
            }

            if (min > sum) {
                answer = i;
                min = sum;
            }
        }

        System.out.println(answer);



    }
}
