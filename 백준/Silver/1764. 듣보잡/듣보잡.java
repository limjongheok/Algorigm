import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static  int N;
    static  int M;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        HashSet<String> hs = new HashSet<>();
        ArrayList<String> arrayList = new ArrayList<>();



        for(int i=0; i<N; i++){
            String name = bf.readLine();
            hs.add(name);

        }

        for(int i =0; i<M; i++){
            String name = bf.readLine();
            if(hs.contains(name)){
                arrayList.add(name);
            }
        }


        
        Collections.sort(arrayList);
        System.out.println(arrayList.size());

        for(String s : arrayList){
            System.out.println(s);
        }



    }
}
