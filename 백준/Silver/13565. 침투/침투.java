import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static  int m;
    private static  int n;
    private static int[][] arr;
    private static boolean[][] visited;
    private static int[] dx = {0,0,1,-1};
    private static int[] dy = {1,-1,0,0};
    private static boolean check = false;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 가로
        m = Integer.parseInt(st.nextToken()); // 세로

        arr = new int[n][m];
        visited = new boolean[n][m];

        // 배열 채우기
        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }

        // 밖에서 전류 흐르기
        for(int i=0; i<m; i++){
            if(arr[0][i] ==0){ // 전류가 통하는 전지
                bfs(0,i); // 종이 태우기
                if(check){
                    break;
                }
            }
        }
        if(check){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }



    }
    private static void bfs(int x, int y){
        visited = new boolean[n][m];

        visited[x][y] = true;

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x,y));

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int z=0; z<size; z++){
               Node nowNode = queue.poll();
               for(int i=0; i<4; i++){
                   int nx = nowNode.x +dx[i];
                   int ny = nowNode.y + dy[i];

                   if(nx == n-1){
                       if(arr[nx][ny] == 0){
                           // 밑으로 내려 갈거니까 근데 현재노드는 이미 0이니 내려온거긴함
                           check = true;
                           break;
                       }
                   }

                   if(nx >= 0 && nx <n){
                       if(ny>=0 && ny<m){
                           if(!visited[nx][ny]){
                               if(arr[nx][ny] == 0){
                                   // 잘 타는 종이 일때
                                   visited[nx][ny] = true;
                                   arr[nx][ny] = 1;
                                   queue.add(new Node(nx,ny));
                               }
                           }
                       }
                   }
               }
            }
        }

    }

    private static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
