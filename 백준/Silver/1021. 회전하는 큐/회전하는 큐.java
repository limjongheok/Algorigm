import java.io.*;
import java.util.*;
class Main{
     public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        LinkedList<Integer> list = new LinkedList();

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i=1; i<=n; i++){
            list.add(i);
        }
        st = new StringTokenizer(br.readLine());

        int count = 0;
        for(int i=0; i<m; i++){
            int a = Integer.parseInt(st.nextToken());

            int idx = list.indexOf(a);


            if(list.size()%2 == 0){
                int mi = list.size()/2-1;

                if(list.get(0) == a){

                    list.removeFirst();
                }else{
                    if(idx<= mi){
                        for(int k=0; k<idx; k++){
                            int r = list.removeFirst();
                            list.addLast(r);

                            count ++;

                        }
                        list.removeFirst();

                    }else{
                        for(int k = list.size(); k>idx; k--){
                            int r= list.removeLast();
                            list.addFirst(r);

                            count++;

                        }

                        list.removeFirst();

                    }
                }

            }else{
                int mi = list.size()/2;

                if(list.get(0) == a){
                    list.removeFirst();
                }else{
                    if(idx<=mi){
                        for(int k=0; k<idx; k++){
                            int r = list.removeFirst();
                            list.addLast(r);

                            count ++;

                        }

                        list.removeFirst();

                    }else{
                        for(int k = list.size(); k>idx; k--){
                            int r= list.removeLast();
                            list.addFirst(r);

                            count ++;

                        }

                        list.removeFirst();

                    }
                }


            }






        }
        System.out.println(count);
    }
}