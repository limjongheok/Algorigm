import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static  int pcNum; // 정점 수
    static int pcNet; // 간선 수

    static  boolean[][] array;
    static  boolean[] check;

    static  int count;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        pcNum = Integer.parseInt(br.readLine()); // 정점 수
        pcNet = Integer.parseInt(br.readLine()); // 간선 수
        array= new boolean[pcNum+1][pcNum+1];
        check = new boolean[pcNum+1];

        // 인접 행렬 구성
        for(int i= 0; i<pcNet; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            array[a][b] = true;
            array[b][a] = true;
        }

        bfs(1);


    }

    public  static  void bfs(int x){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        check[x] =true;


        while(!queue.isEmpty()){
            int a = queue.poll();

            for(int i=0; i<array.length; i++){
                if(array[a][i]){
                    if(!check[i]){
                        queue.offer(i);

                        check[i] = true;
                        count++;
                    }

                }
            }
        }
        System.out.println(count);
    }
}
