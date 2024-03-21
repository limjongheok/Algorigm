import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    static  int m;
    static char[][] arr;
    static boolean[][] visited;
    static  int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int count = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new char[n][m];
        visited = new boolean[n][m];

        int myX = 0;
        int myY = 0;
        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<m; j++){
                arr[i][j] = s.charAt(j);
                if(arr[i][j] == 'I'){
                    myX = i;
                    myY = j;
                }
            }
        }
        bfs(myX,myY);
        if(count==0){
            System.out.println("TT");
        }else {
            System.out.println(count);
        }
    }
    private static void bfs(int x, int y){
        visited[x][y] = true;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x,y));

        while (!queue.isEmpty()){
            int size = queue.size();

            //레벨별 bfs
            for(int z=0; z<size; z++){
                Node nowNode = queue.poll();
                if(arr[nowNode.x][nowNode.y] == 'P'){
                    count++;
                }
                for(int i=0; i<4; i++){
                    int nx = nowNode.x+ dx[i];
                    int ny = nowNode.y + dy[i];
                    if(nx >=0 && nx <n){
                        if(ny>=0 && ny<m){
                            if(!visited[nx][ny]){
                                if(arr[nx][ny]!='X'){
                                    visited[nx][ny] = true;
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
