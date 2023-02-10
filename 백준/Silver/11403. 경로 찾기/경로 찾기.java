import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static  int N; //  정점 개수
    static  int [][] array;

    static  int [] array2;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(bf.readLine());

        array = new int[N+1][N+1];
        array2 = new int[N+1];

        // 배열 만들기
        for(int i=0; i<N; i++){
            st  = new StringTokenizer(bf.readLine());
            for(int j=0; j<N; j++){
                int n = Integer.parseInt(st.nextToken());
                array[i][j] = n;
            }
        }

        //중간 노드 선정
        for(int m=0; m<N; m++){
            for(int i= 0; i<N; i++){
                for(int j=0; j<N; j++ ){
                    // 우선 array[i][j] == 1인경우 최단경로는 아니지라도 경로는 존재
                    // 그리고 array[i][m] == 1 i에서 중간 노드 방문후 array[m][j]  중간노드에서 j 까지 방문시
                    // 경로 존재 즉 array[i][j] = 1
                    if(array[i][m] == 1 && array[m][j] ==1){
                        array[i][j] = 1;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                sb.append(array[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
