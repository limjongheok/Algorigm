import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        Map<Integer,Integer> map = new HashMap();
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int[] clone; // 정렬할 배열
        clone = arr.clone();
        Arrays.sort(clone);
        

        int rank =0;
       for(int v : clone){
           if(!map.containsKey(v)){
               map.put(v,rank++);
           }
       }

        StringBuilder sb = new StringBuilder();
        for(int i : arr){
            int r = map.get(i);
            sb.append(r).append(" ");
            
        }
        System.out.println(sb);

    }
}
