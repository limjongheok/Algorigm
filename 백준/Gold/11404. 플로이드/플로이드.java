import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static  int N; //  도시 개수 정점
    static  int  M ; // 다른 도시에 도착하는 m 개 버스
    static final int INF = 987654321;

    static  int[][] array;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); // 도시 개수(정점)
        M = Integer.parseInt(br.readLine()); // 버수 개수 (간선)

        array = new int[N+1][N+1];
        // 초기값 설정
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                array[i][j] = INF;

                if (i == j) {
                    array[i][j] = 0;
                }
            }
        }


        // 인접 행렬 구현
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int first= Integer.parseInt(st.nextToken());
            int secont = Integer.parseInt(st.nextToken());
            int money = Integer.parseInt(st.nextToken());
            array[first][secont] = Math.min(array[first][secont],money);
        }

        // 플로이드 워셜로 모든 초단 거리 구하기
        for(int m=1; m<=N; m++){
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    if(array[i][j] > array[i][m]+array[m][j]){
                        array[i][j] = array[i][m]+array[m][j];
                    }
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(array[i][j]==INF){
                    array[i][j] = 0;
                }
                sb.append(array[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);






    }
}
