import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[][] arr; // 바둑판
    private static int[] dx = {0 ,1,-1,1}; // 우 , 하, 우상대 ,우하대
    private static int[] dy = {1, 0,1,1};
    private static boolean check;
    private static boolean checkW;
    private static boolean checkB;
    private static int x ;
    private static int y;
    private static int dol;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 바둑판 채우기

        arr = new int[20][20]; // 바둑판


        for(int i=1; i<20; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<20; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        } // 바둑판 채우기


        check = false;
        boolean breaks = false;
        // 바둑판 흑 1 백 2

        for(int i=1; i<20; i++){
            for(int j=1; j<20; j++){
                if(arr[i][j] ==1){

                    dfs(i,j,1);
                    if(check){
                        checkB =true;
                        dol = 1;
                        x = i;
                        y = j;
                        breaks = true;
                        break;
                    }
                }
            }
            if(breaks ){
                break;
            }
        }
        check = false;
        breaks = false;

        for(int i=1; i<20; i++){
            for(int j=1; j<20; j++){
                if(arr[i][j] ==2){

                    dfs(i,j,2);
                    if(check){
                        checkW = true;
                        x = i;
                        y = j;
                        breaks = true;
                        break;
                    }
                }
            }
            if(breaks ){
                break;
            }
        }

        if(checkW && checkB){ // 둘다 5목일시
            System.out.println(0);
        } else if (!checkB && !checkW) { // 둘다 5목이 아닐시
            System.out.println(0);

        } else if (!checkB && checkW) {
            System.out.println(2);
            System.out.println(x+" " +y);
        }else {
            System.out.println(1);
            System.out.println(x+" " +y);
        }


    }
    private static void dfs(int x, int y, int col){
     // 4 방향 탐색

        // 우 하 우상대 우하대
        right(x,y,col);
        down(x,y,col);
        rightup(x,y,col);
        rightdown(x,y,col);



    }
    // 우
    private static void right(int x, int y ,int col){
        int count = 1;
        // 좌측 한칸 보기
        boolean checkBefore = false;
        if(y-1 >=0 && y-1<20){
            if(arr[x][y-1] == col){
                checkBefore = true;
            }
        }

        if(!checkBefore){ // 이전에 없을시
            int nextX = x;
            int nextY = y;
            // 밑으로 한칸식 보내며 탐색;
            for(int i=0; i<6; i++){ // 6개 보내며 탐색
                nextX = nextX +dx[0];
                nextY = nextY+dy[0];
                if(nextX>=0&&nextX<20){
                    if(nextY>=0 && nextY<20){
                        if(arr[nextX][nextY] == col){
                            count++;
                        }else {
                            break;
                        }
                    }
                }
            }
            if(count == 5){
                check = true;
            }
        }

    }
    private static void down(int x, int y, int col){
        int count = 1;
        // 위측 한칸 보기
        boolean checkBefore = false;

        if(x-1 >=0 && x-1<20){
            if(arr[x-1][y] == col){
                checkBefore = true;
            }
        }

        if(!checkBefore){
            int nextX = x;
            int nextY = y;
            // 밑으로 한칸식 보내며 탐색;
            for(int i=0; i<6; i++){ // 6개 보내며 탐색
                nextX = nextX +dx[1];
                nextY = nextY+dy[1];
                if(nextX>=0&&nextX<20){
                    if(nextY>=0 && nextY<20){
                        if(arr[nextX][nextY] == col){
                            count++;
                        }else {
                            break;
                        }
                    }
                }
            }
            if(count == 5){
                check = true;
            }
        }

    }
    private static void rightup(int x , int y, int col){
        int count = 1;
        // 위측 한칸 보기
        boolean checkBefore = false;
        if(x+1 >=0 && x+1<20){
            if(y-1>=0 && y-1<20){
                if(arr[x+1][y-1] == col){
                    checkBefore = true;
                }
            }
        }

        if(!checkBefore){
            int nextX = x;
            int nextY = y;
            // 밑으로 한칸식 보내며 탐색;
            for(int i=0; i<6; i++){ // 6개 보내며 탐색
                nextX = nextX +dx[2];
                nextY = nextY+dy[2];
                if(nextX>=0&&nextX<20){
                    if(nextY>=0 && nextY<20){
                        if(arr[nextX][nextY] == col){
                            count++;
                        }else {
                            break;
                        }
                    }
                }
            }
            if(count == 5){
                check = true;
            }
        }

    }

    private static void rightdown(int x , int y, int col){
        int count = 1;
        // 위측 한칸 보기
        boolean checkBefore = false;
        if(x-1 >=0 && x-1<20){
            if(y-1>=0 && y-1<20){
                if(arr[x-1][y-1] == col){
                    checkBefore = true;
                }
            }
        }

        if(!checkBefore){
            int nextX = x;
            int nextY = y;
            // 밑으로 한칸식 보내며 탐색;
            for(int i=0; i<6; i++){ // 6개 보내며 탐색
                nextX = nextX +dx[3];
                nextY = nextY+dy[3];
                if(nextX>=0&&nextX<20){
                    if(nextY>=0 && nextY<20){
                        if(arr[nextX][nextY] == col){
                            count++;
                        }else{
                            break;
                        }
                    }
                }
            }
            if(count == 5){
                check = true;
            }
        }

    }
}