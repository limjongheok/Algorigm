import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static  int[][] arr;
    private static int[] dx = {1,0,-1,0};
    private static int[] dy = {0,1,0,-1};
    private static  int n;
    private static int m;
    private static boolean[][] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st ;
        st = new StringTokenizer(br.readLine());
         n = Integer.parseInt(st.nextToken());
         m =Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }



        for(int i=0; i<r; i++){
            int x = 0;
            int y = 0;
            visited = new boolean[n][m];
            reverse(n,m,x,y);


        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 짝수 홀수 나눠야함
    private static void reverse(int x, int y, int startX, int startY ){
        // y 좌표와 sPoint
        // y 좌표 -2 하기
        // 5 3 1  즉 y가 처음 홀수면 1에서 종료
        // 4 2 0  즉 y가 0이면 종료


        if(n>m){
            if(m%2==1){
                if(y==1){
                    return;
                }
            }else{
                if(y==0){
                    return;
                }
            }
        }else{
            if(n%2==1){
                if(x==1){
                    return;
                }
            }else{
                if(x==0){
                    return;
                }
            }
        }


        int nextX = startX;
        int nextY = startY;
        // 0에서 시작
        int nextNode = arr[startX][startY];
        // 밑으로 이동
        for(int i=0; i<x-1; i++){
            startX = startX+dx[0];
            int idx = arr[startX][startY];
            arr[startX][startY] = nextNode;
            nextNode = idx;
        }

        // 오른쪽 이동
        for(int i=0; i<y-1; i++){
             startY = startY + dy[1];
            int idx = arr[startX][startY];
            arr[startX][startY] = nextNode;
            nextNode = idx;
        }

        // 위 이동
        for(int i=0; i<x-1; i++){
            startX = startX + dx[2];
            int idx = arr[startX][startY];
            arr[startX][startY] = nextNode;
            nextNode = idx;
        }
        // 왼쪽
        for(int i=0; i<y-1; i++){
            startY = startY + dy[3];
            int idx = arr[startX][startY];
            arr[startX][startY] = nextNode;
            nextNode = idx;
        }


        // 다 돌면
        reverse(x-2,y-2,nextX+1,nextY+1);

    }



}