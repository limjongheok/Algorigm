import java.io.IOException;
import java.io.*;
import java.util.*;
public class Main {

    private static BufferedReader br;
    private  static StringTokenizer st;

    private static  ArrayList<List> graph;
    private  static int[] visit;

    private  static int v;

    private  static boolean s;
    public static void main(String[] args)throws IOException{

        br = new BufferedReader(new InputStreamReader(System.in));


        int tk = Integer.parseInt(br.readLine());


        for(int i=0; i<tk; i++){
            st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            graph = new ArrayList();

            for(int j=0; j<=v; j++){
                graph.add(new ArrayList<Integer>());
            }
            putGraph(m);
            visit = new int[v+1];


            s = true;
            for(int j=1; j<=v; j++){

                if(visit[j] ==0){
                    
                    bfs(j);
                }
            }



            if(!s){
                System.out.println("NO");
            }else{
                System.out.println("YES");
            }


        }
    }

    private static void putGraph(int m) throws IOException{
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int fstNode = Integer.parseInt(st.nextToken());
            int secNode = Integer.parseInt(st.nextToken());

            graph.get(fstNode).add(secNode);
            graph.get(secNode).add(fstNode);

        }
    }
    private  static void bfs(int node){
        visit[node] = 1;

        Queue<Integer> queue = new LinkedList();
        queue.offer(node);

        while(!queue.isEmpty()){
            int pq = queue.poll();

            for(Object i : graph.get(pq)){
                int a = (Integer) i;


                if(visit[a] == 0){ // 방문 안했을시
                    queue.offer(a);

                    if(visit[pq] == 1){
                        visit[a] = 2;
                    }else{
                        visit[a] =1;
                    }
                }else{// 방문 한 노드
                    if(visit[pq] == 1){ // 현재 노드

                        if(visit[a] == 1){
                            s = false;
                            break;
                        }
                    } else if (visit[pq] ==2) {
                        if(visit[a] == 2){

                            s = false;
                        }
                    }

                }
            }
        }
    }
}


