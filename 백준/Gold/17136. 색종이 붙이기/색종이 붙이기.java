import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] re = {0,5,5,5,5,5};
    static int[][] arr;
    static boolean[][] visited;
    static int min;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        StringTokenizer st;


        arr = new int[10][10];
        visited = new boolean[10][10];

        for(int i=0; i<10; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<10; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        min = Integer.MAX_VALUE;
        dfs(0,0,0);

        if(min == Integer.MAX_VALUE){
            System.out.println(-1);
        }else {
            System.out.println(min);
        }

    }
    private static void dfs(int x, int y, int count) {
        if(x >=9 && y > 9){
            min = Math.min(count, min);
            return;
        }
        if(count > min)return;;
        if(y > 9){
            dfs(x+1,0, count); // x 축 증가
            return;
        }

        if(arr[x][y] == 1){
            for(int i=5; i>=1; i--){
                if(re[i]!=0 && check(x,y,i)){
                    paper(x,y,i,0); // 종이 때기
                    re[i]--;
                    dfs(x,y+1,count+1);
                    paper(x,y,i,1); // 종이 붙이기
                    re[i] ++;
                }

            }
        }else {
            dfs(x,y+1,count);
        }

    }
    private static  void paper(int x, int y,int count, int state){
        for(int i=x; i<count +x ; i++){
            for(int j=y; j<y+count; j++){
                arr[i][j] = state;
            }
        }
    }

    private static boolean check(int x, int y, int cnt){
        for(int i=x; i<x+cnt; i++){
            for(int j=y; j<y+cnt; j++){
                if(i <0 || i>=10 || j <0 || j>=10){
                    return   false;
                }
                if(arr[i][j] == 0){
                    return  false;
                }

            }
        }
        return true;

    }

}
