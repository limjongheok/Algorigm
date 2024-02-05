import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m =Integer.parseInt(st.nextToken());
        Deque<Integer> deque = new LinkedList<>();

        int count = 1;
        for(int i=1; i<=n; i++){
            deque.add(i);
        }

        int[] arr = new int[deque.size()];
        int i = 0;
        while(!deque.isEmpty()){

            if(count ==m){
                arr[i] = deque.pollFirst();
                i++;
                count = 0;
            }else{
                deque.addLast(deque.pollFirst());
            }
            count++;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<" );
        for(int j=0; j<arr.length-1; j++){
            sb.append(arr[j] + ","+" ");
        }
        sb.append(arr[arr.length-1] + ">");
        System.out.println(sb);


    }
}