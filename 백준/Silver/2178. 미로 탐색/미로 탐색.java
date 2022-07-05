import  java.util.*;


public class Main {
    static int N;
    static int M;
    static boolean[][] check;
    static int[] updonwn= new int[]{-1,0,1,0};
    static int[] leftright = new int[]{0,-1,0,1};

    static int[][] miro;
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M= sc.nextInt();

        check =new boolean[N][M];


        miro = new int[N][M];

        // create miro
        for(int i=0; i<N; i++){

            String len = sc.next();
            for(int j=0; j<M; j++){
                miro[i][j] = len.charAt(j)-'0';
            }
        }

        // check
//
//        for(int i=1; i<=N; i++){
//            for(int j=1; j<=M; j++){
//                System.out.print(miro[i][j]);
//            }
//            System.out.println(" ");
//        }
        
        check[0][0] = true;

        bfs(0,0);
        System.out.println(miro[N-1][M-1]);


    }
    public static void  bfs(int i,int j){
        
        Queue<dot> queue = new LinkedList<>();
        queue.add(new dot(i,j));
        while (!queue.isEmpty()){
            dot d = queue.poll();


            for(int k=0; k<4; k++){
                int nextx = d.x+updonwn[k];
                int nexty = d.y+leftright[k];
                //System.out.println(updonwn[k]);
                if(nextx <0 || nexty<0 || nextx>=N || nexty>=M ){
                    continue;
                }
                // 방문 좌표거나 0일경우 건너 뛰기
                if(check[nextx][nexty] || miro[nextx][nexty] == 0 ){
                    continue;
                }
                
                queue.add(new dot(nextx,nexty));
                miro[nextx][nexty] = miro[d.x][d.y]+1;
                check[nextx][nexty]= true;
                
            }

        }



    }
}
class dot{
    int x;
    int y;
    public dot(int x, int y){
        this.x = x;
        this.y =y;
    }
}