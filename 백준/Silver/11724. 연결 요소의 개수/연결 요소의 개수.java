import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N;
    static  int M;
    static int arr[][] ;
    static int visit[] ; //정점 방문 여부
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 정점 개수
        M = sc.nextInt(); // 간선 개수
        visit = new int[N+1];
        arr= new int[N+1][N+1];


        // 인접 행렬 채우기
        for(int i=0; i<M; i++){
            int u= sc.nextInt();
            int v = sc.nextInt();
            arr[u][v] =1;
            arr[v][u] =1;
        }

        // 확인
      //  for(int i=1; i<N; i++){
     //       for(int j=1; j<N; j++){
      //          System.out.print(arr[i][j]);
      //      }
      //     System.out.println(" ");
      //  }

        int count =0;
        //BFS
        for(int i=1; i<=N; i++){
            if(visit[i]==0){
                count++;
                visit[i]=1; // 방문 시키기
                bfs(i);

            }

        }
        System.out.println(count);

    }
    public static void bfs(int i){
        Queue<Integer> queue = new LinkedList<>(); //queue 선언
        queue.offer(i); // queue에 정점 삽입

        while(!queue.isEmpty()){ // 큐가 비지 않을경우
            int quqpop = queue.poll(); // queue 첫번째 빼주기
            for(i=1;i<=N; i++){
                if(visit[i]!=1 && arr[quqpop][i]==1){
                    queue.offer(i);
                    visit[i]= 1;
                }
            }


        }
    }

}