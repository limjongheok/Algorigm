import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int[][] arr;
    private static int n;
    private static int m;
    private static List<Nodes> list ;
    private static int[] chX;
    private static int[] chY;

    private static boolean[] visited;
    private static int sum =0;
    private static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st ;
        st = new StringTokenizer(br.readLine());

        //1. 입력 n arr[n][n] m 추출 치킨집
         n = Integer.parseInt(st.nextToken());
         m = Integer.parseInt(st.nextToken());

         arr = new int[n][n];
         list = new ArrayList<>();
         for(int i=0; i<n; i++){ // n 줄 만큼 입력
             st = new StringTokenizer(br.readLine());
             for(int j=0; j<n; j++){
                 arr[i][j] = Integer.parseInt(st.nextToken());
                 // 2 일때 추출
                 if(arr[i][j]==2){
                     list.add(new Nodes(i,j));
                 }
             }
         }
         visited = new boolean[list.size()];
         chX = new int[list.size()];
         chY = new int[list.size()];

         int count = 0;
         for(Nodes i: list){
             int x = i.x;
             int y = i.y;
             chX[count] = x;
             chY[count] = y;
             count++;
         }
         int[] arrX = new int[m];
         int[] arrY = new int[m];

         dfs(0,0,arrX,arrY);
         System.out.println(result);


    }



    private static void dfs(int idx,int v, int[] arrX, int[] arrY){
        if(idx == m){ // 2 개 추출시 멈춤
            sum = 0;
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(arr[i][j]==1){
                        result( i,  j, arrX, arrY); // 결과 구하기
                    }
                }
            }
            result = Math.min(result,sum);
            return ;
        }

        for(int i=v; i<chX.length; i++){
            visited[i] = true;
            arrX[idx] = chX[i];
            arrY[idx] = chY[i];
            dfs(idx+1,i+1,arrX,arrY);
            visited[i] = false;
        }
    }

    private static void result(int x, int y , int[] arrX, int[] arrY){
        // 최소 길이 구하기

        int min = Integer.MAX_VALUE;
        for(int i=0; i<arrX.length; i++){
            min = Math.min(Math.abs(x-arrX[i])+Math.abs(y-arrY[i]),min);
        }

        sum+=min;


    }
}
class Nodes{
    int x;
    int y;
    public Nodes(int x, int y){
        this.x=x;
        this.y=y;
    }
}