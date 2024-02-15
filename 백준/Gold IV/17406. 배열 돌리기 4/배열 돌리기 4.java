import java.io.*;
import java.util.*;

public class Main {
    private static int[][] arr;
    private static int[][] copyArr;
    private static int n;
    private static int m;
    private static int colSize;
    private static int[] dx = {1,-1};
    private static int[] dy = {1,-1};
    private static boolean[] visited;
    private static int[][] orders;
    private static int k;
    private static int r;
    private static int c;
    private static int s;
    private static int min;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken()); // 연산 개수

        //1. 배열 채우기
        arr = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

         orders = new int[k][3];

        // 연산 받기
        for(int order=0; order<k; order++){
            st = new StringTokenizer(br.readLine());
             r = Integer.parseInt(st.nextToken()) -1; //0 0 배열 시작이므로
             c = Integer.parseInt(st.nextToken()) -1;
             s = Integer.parseInt(st.nextToken());

            int[] o = new int[3];
            o[0] = r;
            o[1] = c;
            o[2] = s;
            // 명령 조합에 담기
            orders[order] = o;
        }
        // 명령 조합 구하기
        visited = new boolean[k];
        int[][] reOrder = new int[k][3];
        min = Integer.MAX_VALUE;
        re(0,reOrder);

        // 최솟값 구하기
        System.out.println(min);

    }

    private static void re(int idx,  int[][] reIrOrder){
        if(idx == k){
            copy(r,c,s); // 배열 복사
            // 여 조합으로 배열돌리기
            for(int i=0; i<reIrOrder.length; i++){
                int r = reIrOrder[i][0];
                int c = reIrOrder[i][1];
                int s = reIrOrder[i][2];
                int startX = startX(r,s);
                int endX = endX(r,s);
                int startY = startY(c,s);
                int endY = endY(c,s);
                colSize = endX-startX;
                int size = endX-startX;
                dfs(startX,startY, endX,endY,size);
            }
            minVal();

            return;
        }

        for(int i=0; i<k; i++){
            if(!visited[i]){
                visited[i] = true;
                reIrOrder[idx] = orders[i];
                re(idx+1,reIrOrder);
                visited[i] = false;
            }
        }
    }

    // 배열 카피 하기
    private static void copy(int r, int c, int s){
        copyArr = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j = 0; j<m; j++){
                copyArr[i][j] = arr[i][j];
            }
        }

    }
    private static void dfs(int startX, int startY,int endX, int endY, int size){
           // 시작 x
        if(colSize%2==0){ //세로가 짝수일때
            if(size == 0){
                return;
            }
        }else{
            if(size == 1){
                return;
            }
        }


        int x = startX;
        int y = startY;
        int pre = copyArr[x][y];


        /// 배열 돌리기

        // 우
        for(int i=startY; i<endY; i++){
            y = y +dy[0];
            int next = copyArr[x][y];
            copyArr[x][y] = pre;
            pre = next;
        }

        // 하
        for(int i=startX; i<endX; i++){
            x = x +dx[0];
            int next = copyArr[x][y];
            copyArr[x][y] = pre;
            pre = next;
        }

        // 좌
        for(int i=startY; i<endY; i++){
            y = y +dy[1];
            int next = copyArr[x][y];
            copyArr[x][y] = pre;
            pre = next;
        }

        // 상
        for(int i=startX; i<endX; i++){
            x = x +dy[1];
            int next = copyArr[x][y];
            copyArr[x][y] = pre;
            pre = next;
        }

        dfs(startX+1,startY+1,endX-1,endY-1,size-2);


    }


    // 시작 끝 지점
    private static int startX (int r, int s){
        return r-s;
    } private static int endX (int r, int s){
        return r+s;
    } private static int startY (int c, int s){
        return c-s;
    } private static int endY (int c, int s){
        return c+s;
    }

    private static void minVal(){
        int sum = 0;
        for(int i=0; i<copyArr.length; i++){
            for(int j=0; j<copyArr[i].length; j++){
                sum+=copyArr[i][j];
            }
            min = Math.min(min,sum);
            sum = 0;
        }

    }


    // 배열 출력 테스트
    private static void testArrPrint(int[][] arr){
        for(int i=0;i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}