import java.util.*;
import java.io.*;

public class Main {
    private static char[][] arr;
    private static char[][] arr2;
    private static boolean[][] check;
    private static boolean[][] check2;
    private static int n;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        n = Integer.parseInt(br.readLine());

        arr = new char[n][n];
        arr2 = new char[n][n];

        check = new boolean[n][n];
        check2 = new boolean[n][n];


        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {

                arr[i][j] = s.charAt(j);
                if(arr[i][j] == 'G'){
                    arr2[i][j] = 'R';
                }else{
                    arr2[i][j] = s.charAt(j);
                }
            }
        }
        int noSeek = 0;
        int seek = 0;

        for(int i=0; i<n; i++){
            for(int j =0; j<n; j++){
                if(!check[i][j]){
                    noSeek++;
                    bfs(i,j);
                }

                if(!check2[i][j]){
                    seek++;
                    bfs2(i,j);
                }
            }
        }

        System.out.println(noSeek + " " + seek );

    }

    private static void bfs(int x, int y) {
        check[x][y] = true;
        Queue<Node> queue = new LinkedList();

        queue.add(new Node(x, y));

        char nowCal = arr[x][y];

        while (!queue.isEmpty()) {
            Node nowNode = queue.poll();
            int nowX = nowNode.x;
            int nowY = nowNode.y;

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX >= 0 && nextX < n) {
                    if (nextY >= 0 & nextY < n) {
                        if (arr[nextX][nextY] == nowCal) {
                            if(!check[nextX][nextY]){
                                check[nextX][nextY] = true; // 다음노드 방문 check
                                queue.add(new Node(nextX, nextY)); //  다음 노드 방문
                            }

                        }
                    }
                }
            }
        }
    }

    private static void bfs2(int x, int y) {
        check2[x][y] = true;
        Queue<Node> queue = new LinkedList();

        queue.add(new Node(x, y));

        char nowCal = arr2[x][y];

        while (!queue.isEmpty()) {
            Node nowNode = queue.poll();
            int nowX = nowNode.x;
            int nowY = nowNode.y;

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX >= 0 && nextX < n) {
                    if (nextY >= 0 & nextY < n) {
                        if (arr2[nextX][nextY] == nowCal) {
                            if(!check2[nextX][nextY]){
                                check2[nextX][nextY] = true; // 다음노드 방문 check
                                queue.add(new Node(nextX, nextY)); //  다음 노드 방문
                            }

                        }
                    }
                }
            }
        }
    }



}


class Node{
    int x;
    int y;

    public Node(int x,int y){
        this.x = x;
        this.y = y;
    }
}