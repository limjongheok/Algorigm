import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        int tk = Integer.parseInt(br.readLine());

        for(int i=0; i<tk; i++){
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            LinkedList<Integer> queue = new LinkedList();
            LinkedList<Integer> queue1 = new LinkedList();

            List<Integer> list = new ArrayList();
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                int a = Integer.parseInt(st.nextToken());

                queue.add(a);
                queue1.add(j);
            }

            while(!queue.isEmpty()){
                int max = queue.get(0);


                for(int z=0; z<queue.size(); z++){
                    if(max<queue.get(z)){
                        max = queue.get(z);
                    }
                }


                int pq = queue.pop();
                int p1q = queue1.pop();
                if(pq!=max){
                    queue.add(pq);
                    queue1.add(p1q);
                }else{
                    list.add(p1q);
                }
            }

            int count = 1;
            for(int a=0; a<list.size(); a++){
                if(list.get(a) == m){
                    System.out.println(count);
                }else {
                    count++;
                }
            }

        }


    }
    
}