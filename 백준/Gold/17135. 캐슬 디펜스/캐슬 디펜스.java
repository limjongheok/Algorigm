import java.io.*;
import java.util.*;
public class Main {
    private static int n;
    private static int m;
    private static int v;
    private static int[][] arr;
    private static int[][] copyArr;
    private static boolean[] robinCheck;
    private static boolean[][] visited;
    private static int dieCount;
    private static int[] hitX ={0,-1,0};
    private static  int[] hitY = {-1,0,1}; // 왼 위 오
    private static int max;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

         n = Integer.parseInt(st.nextToken());
         m= Integer.parseInt(st.nextToken());
         v = Integer.parseInt(st.nextToken());

        arr = new int[n+1][m];


        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] robins = new int[3];
        robinCheck = new boolean[m];
        max = Integer.MIN_VALUE;
        robinGet(0,0,robins); // 구성 설정
        System.out.println(max);
    }

    private static void robinGet(int idx, int num,int[] robins){
        if(idx == 3){
            copyArr = new int[n+1][m];

            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    copyArr[i][j] = arr[i][j];
                }
            }
            //copyArr 초기화
            for(int robin  : robins){
                copyArr[n][robin] = 2; // 2 면 궁수
            }
            dieCount = 0;

            // 궁수 v 거리만큼 화살 싸서 맞추기
            // 병사 이동하기
            enemy(robins); // 두개를 합친 추상 함수
            max = Math.max(max,dieCount);
            return ; // 궁수 3명 종료
        }

        for(int i=num; i<m; i++){
            if(!robinCheck[i]){
                robinCheck[i] = true;
                robins[idx] = i;
                robinGet(idx+1,i+1,robins);
                robinCheck[i] = false;
            }

        }
    }
    private static void enemy(int[] robins){
        // 병사가 해야할 일은
        // 1. 화살 맞고 죽기
        // 2. 한칸 앞으로 이동하기

        // 언제까지 병사가 다 죽을때 까지


        while(true){

            if(checkEnemy()){
                break;
            }
            // 적이 없음 1. 화살 쏘기
            hit(robins);
            // 적 한칸 앞으로 이동
            move();

        }


    }

    private static boolean checkEnemy(){
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(copyArr[i][j] == 1){

                    return false; // 적이 있어요
                }
            }
        }
        return true;
    }

    private static void hit(int[] robins){

        Arrow[] arrows = new Arrow[3]; // 화살 3개 죽은 적 3명
        for(int i=0; i<robins.length; i++){
            int robinX = n;
            int robinY = robins[i];
            visited = new boolean[n][m];
            arrows[i] = shot(robinX, robinY);
        }
        die(arrows);
    }

    private static void die(Arrow[] arrows){
        // 적 죽이기

        for(int i=0; i<arrows.length; i++){
            Arrow arrow = arrows[i];

            if(arrow != null){
                int x =arrow.x;
                int y = arrow.y;
                if(copyArr[x][y] == 1){
                    // 적이 있을 겨우
                    copyArr[x][y] = 0; // 적을 죽인 후
                    dieCount++;
                }
            }


        }
    }

    private static Arrow shot(int x, int y){

        Queue<Arrow> queue = new LinkedList();
        queue.add(new Arrow(x,y,0));
        // 다음 노드 부터 담길거

        while(!queue.isEmpty()){
            Arrow nowArrow = queue.poll();
            int nowX = nowArrow.x;
            int nowY = nowArrow.y;
            int nowCount = nowArrow.count;

            for(int i=0; i<3; i++){
                int nextX = nowX +hitX[i];
                int nextY = nowY + hitY[i];
                int nextCount = nowCount +1;

                if(nextX >=0 && nextX<n){
                   if(nextY >=0 && nextY<m){
                       if(!visited[nextX][nextY]){
                           if(copyArr[nextX][nextY] == 0){
                               if(nextCount < v){ // 거리보다 작을때
                                   queue.add(new Arrow(nextX,nextY,nextCount));
                               }
                           }else{ // 거리가 되었는데
                               return new Arrow(nextX,nextY,nextCount); // 화살 출력
                           }

                       }
                   }
                }
            }
        }
        return null;


    }

    private static void move(){ // 적 한칸 앞으로 이동

        //밑에서 부터 이동
        for(int i=0; i<m; i++){
            for(int j=n-1; j>=0; j--){
                if(copyArr[j][i] ==1){
                    int nextX = j+1;
                    if(nextX <n){
                        copyArr[nextX][i] = copyArr[j][i]; // 다음 좌표는 현재좌표
                        copyArr[j][i] = 0; // 현재 좌표 0
                    }else{
                        copyArr[j][i] = 0; // 성 도달시 0
                    }
                }

            }
        }
    }

    private static class Arrow{
        int x;
        int y;
        int count;
        public Arrow(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    private static void robinPrint(int[] robin){
        for(int i=0; i<robin.length; i++){
            System.out.print(robin[i] + " ");
        }
        System.out.println();
    }

    private static void printCopyArr(){
        for(int i=0; i<=n; i++){
            for(int j=0; j<m; j++){
                System.out.print(copyArr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


}
