import java.util.*;


public class Main {
    static int N;
    static  int M;
    static int K;
    static int[][] point;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static boolean[][] check;
    static int len;
    static int max;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        

        point = new  int[N][M];
        check = new boolean[N][M];

        // 좌표 받기
        for(int i =0; i<K; i++){
            int one = (sc.nextInt());
            int two = (sc.nextInt());
            point[one-1][two-1] = 1;

        }
        // 좌표에 값 넣기



        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(check[i][j]== false && point[i][j] ==1){
                    len =0;
                    bfss(i,j); // 연결트리 true 설정
                    max = Math.max(len,max);




                }
            }
        }
        System.out.println(max);


    }

    public static void bfss(int x, int y) {
        check[x][y] = true;
        len++;
        Queue<dots> queue = new LinkedList<>();
        queue.add(new dots(x,y));

        while(!queue.isEmpty()){

            dots d = queue.poll(); //다음 큐

            for(int i=0; i<4; i++){
                int xx = d.x + dx[i];
                int yy = d.y + dy[i];

                if(xx<0 || yy<0 || xx>=N || yy>=M)continue;
                if(!check[xx][yy] && point[xx][yy]==1) {
                    queue.add(new dots(xx, yy));
                    check[xx][yy]=true;
                    len++;
                }
            }

        }


    }
}
class dots{
    int x;
    int y;
    public dots(int x, int y){
        this.x = x;
        this.y =y;
    }
}