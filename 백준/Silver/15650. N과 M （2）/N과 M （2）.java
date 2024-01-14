import java.util.*;
import java.io.*;

class Main{
    private static boolean[] visited;
    private static int[] arr;
    private static int n;
    private static int m;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];

        visited = new boolean[n];


        dfs(0,0);



    }

    private static void dfs(int start,int r){
        if(start == m){
            for(int i=0; i<arr.length; i++){
                System.out.print(arr[i]  + " ");
            }
            System.out.println();
            return ;
        }


        for(int i=0; i<n; i++){
                if(!visited[i]){// 방문하지 않았을시
                    //이전 노드 검사\
                    //System.out.println(i + " " +r);
                    if(i>=r){
                        if(start <= i){
                            visited[i] = true;
                            arr[start] = i+1;
                            dfs(start+1,i);
                            visited[i] = false;

                        }
                    }





            }

        }

    }
}
