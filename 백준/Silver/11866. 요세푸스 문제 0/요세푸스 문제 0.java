import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList();
        List<Integer> list = new ArrayList();
        for(int i =1; i<=n; i++){
            q.add(i);
        }

        int c =1;
        while(!q.isEmpty()){
            if(c%k==0){
                int p = q.poll();

                list.add(p);
            }else{
                int p = q.poll();

                q.add(p);
            }
            c++;
        }
        System.out.print("<");
        for(int i=0; i<n; i++){


            if(i== n-1){
                System.out.print(list.get(i));
                System.out.print(">");
                continue;
            }
            System.out.print(list.get(i) + ", ");
        }




    }
}