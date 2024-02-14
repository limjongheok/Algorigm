import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static char[][] arr;
    private static int[] dx = {-1,0,1}; // 우 우하 우상
    private static int[] dy = {1,1,1};

    private static int r;
    private static int c;

    private static boolean[][] visited;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //1. 입력 r c
        st = new StringTokenizer(br.readLine());

         r = Integer.parseInt(st.nextToken());
         c = Integer.parseInt(st.nextToken());

        arr = new char[r][c];
        visited = new boolean[r][c];
        // 각 배열 맞게 입력

        for(int i=0; i<r; i++){
            String s=  br.readLine();
            for(int j=0; j<c; j++){
                arr[i][j] = (s.charAt(j));
            }
        }

        int count = 0;

        for(int i=0; i<r; i++){
            if(dfs(i,0)){
                count++;
            }

        }
        System.out.println(count);





    }

    private static boolean dfs(int x, int y){


        if(y == c-1){ // 만약 빵집 위치 까지 도달할시 [0~r][c] 까지 도달했을시
            return true;
        }

        // 4. 탐색은 우상 우하 우

        for(int i=0; i<3; i++){
            int nextX= x+dx[i];
            int nextY = y+dy[i];

            if(nextX >=0&& nextX<r){
                if(nextY>=0 && nextY <c){
                    if(arr[nextX][nextY]=='.'){
                        // 방문을 안한거야
                        if(!visited[nextX][nextY]){
                            visited[nextX][nextY] = true;
                            if(dfs(nextX,nextY)){
                                return true;
                            }

                        }
                    }

                }
            }
        }
        return false;

    }


}