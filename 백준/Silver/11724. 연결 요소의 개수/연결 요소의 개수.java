
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static  int count = 0 ;
    static boolean[] check ;
    static  int n;
    static  int[][] arr;

    public static  void main(String[] args) throws IOException {

        // 입력

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st= new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 정점 개수
        int m = Integer.parseInt(st.nextToken()); // 간선 개수

        // System.out.println(m);  출력 확인


        //인접 행렬을 통해 해결
        // 정점은 총 n 개 있고  양방향 구래프 이니 (0 재외)n+1*n+1 개의 방이 있음
        // 이 n*n의 배열은 전부 0 으로 되어 있고 양 끝점이 주어지면 만약  1 3 이 주어지면  배열[1][3]  [3][1]  = 1 로 채워줌


        // 배열 생성
        // 기본 타입 초기화는  초기값 0 참조 타입은 null

        arr = new int[n+1][n+1];


        // m줄에 걸쳐  양 끝점 u v  주어짐
        for(int i=1; i<=m; i++){
            st= new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());



           // 양 끝점이 주어지면 만약  1 3 이 주어지면  배열[1][3]  [3][1]  = 1 로 채워줌
            arr[u][v] = 1;
            arr[v][u] = 1;

        }

//        for(int i =1; i<n+1 ; i++){
////            for(int j =1; j<n+1; j++){
////                System.out.print(arr[i][j]); // 확인 코드
////            }
////            System.out.println();
////        } 확인




        check = new boolean[n+1];



        // 완전 탐색
        for(int i=1; i<n+1; i++){
            if(check[i]==false){
                count = count +1;
                bfs(i);
            }
        }


        System.out.println(count);



        //arr 가 1 일시 bfs 시작하고 check  하고 count 증가
    }

    public static void bfs(int x){

        Queue<Integer> queue = new LinkedList();
        check[x] = true;
       // System.out.println(x + " " + y);

        queue.add(x);
        while(!queue.isEmpty()){
            int py =  queue.poll();
            //System.out.println(px+"px" + py + "py");

            for(int i=1; i<=n; i++){
                if(check[i]!= true && arr[py][i] == 1){
                    queue.offer(i);
                    check[i] = true;
                }
            }






        }
    }
}


