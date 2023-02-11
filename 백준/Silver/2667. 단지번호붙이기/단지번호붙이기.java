import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static  int N;
    static  int[][] array;
    static  boolean[][] check;

    static  int[] dx = {0,-1,0,1};
    static  int[] dy = {1,0,-1,0};
    static  int count;
    static ArrayList arrayList = new ArrayList();



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        N= Integer.parseInt(br.readLine());

        array = new int[N+1][N+1];
        check = new boolean[N+1][N+1];

        for(int i=0; i<N; i++){
            String a = br.readLine();
            for(int j= 0; j<N; j++){
                array[i][j] = Integer.parseInt(String.valueOf(a.charAt(j)));
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!check[i][j]){
                    if(array[i][j]== 1){
                        bfs(i,j);
                    }
                }
            }
        }

        Collections.sort(arrayList);
        System.out.println(arrayList.size());
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<arrayList.size(); i++){
            sb.append(arrayList.get(i));
            sb.append("\n");
        }
        System.out.println(sb);



    }

    public static  void bfs(int x, int y){
        Queue<dot> queue = new LinkedList<>();
        queue.add(new dot(x,y));
        check[x][y] = true;
        count = 1;
        while(!queue.isEmpty()){
            dot dot = queue.poll();
            int nowX = dot.x;
            int nowY = dot.y;
            for(int i=0; i<4; i++){
                int nextX = nowX + dx[i];
                int nextY = nowY +dy[i];

                if(nextX>=0 && nextX<N){
                    if(nextY>=0 && nextY<N){
                        if(!check[nextX][nextY]){ // 다음이 방문하지 않고
                            if(array[nextX][nextY]== 1){ // 다음 집이 있을시
                                check[nextX][nextY] = true; // 방문하고
                                queue.add(new dot(nextX, nextY)); // 다음 노드로 이동
                                count++;

                            }

                        }

                    }
                }
            }
        }
        arrayList.add(count);

    }

    protected  static  class dot{
        int x;
        int y;

        public dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
