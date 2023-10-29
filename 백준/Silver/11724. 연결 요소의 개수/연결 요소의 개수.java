
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] arrays;
    static boolean[] visited;
    static  int N;
    static  int M;


    public static  void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(bf.readLine());


        N = Integer.parseInt(st.nextToken());// 정점
        M = Integer.parseInt(st.nextToken()); // 간선

        arrays = new boolean[N+1][N+1];
        visited = new boolean[N+1];

        // 간선을 이용해서 행렬 만들기
        for(int i=0; i<M; i++){
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arrays[u][v] = true;
            arrays[v][u] = true;
        }
        int cnt = 0;

        for(int i=1; i<N+1; i++){
            if(!visited[i]){ // 노드에 방문 하지 않을시
                visited[i] = true; // 노드에 방문해 주고
                cnt ++;
                dfs(i);

            }

        }
        System.out.println(cnt);





    }

    public static void dfs(int x){
        // 해당 노드에 방문했음
        // 그럼 인접 노드를 찾아야함


        // 스택을 만들기
        Stack<Integer> stack = new Stack<>();
        stack.add(x);

        while(!stack.isEmpty()){
            int stackPop = stack.pop();

            for(int i=1; i<N+1; i++){ //정점 만큼 돌려서
                if(!visited[i] && arrays[stackPop][i]){
                    // 만약 방문을 안하고, 인접 노드일시
                    visited[i] = true;
                    stack.add(i); // [2, 5]   ,[4,6] ,
                }

            }




        }




    }


}
