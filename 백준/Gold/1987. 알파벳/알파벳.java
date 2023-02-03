
import java.util.Scanner;

public class Main {
    static int R, C;
    static int[][] bord;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int  count = 0;
    static boolean[] check;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        R = scan.nextInt();
        C = scan.nextInt();
        scan.nextLine();

        bord = new int[R][C];
        for(int i = 0; i < R; i++) {
            String str = scan.nextLine();
            for(int j = 0; j < C; j++) {
                bord[i][j] = str.charAt(j) - 'A';
            }
        }

        check = new boolean[26];


        dfs(0,0,1);
         System.out.println(count);



    }

    private static void dfs(int i, int j,int len) {
        check[bord[i][j]] = true;
         count= Math.max(count, len);

        for(int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];
            if(nx >= 0 && ny >= 0 && nx < R && ny < C) {
                if(check[bord[nx][ny]] == false) {
                    dfs(nx, ny, len + 1);
                    check[bord[nx][ny]] = false;
                }
            }
        }

    }
}
