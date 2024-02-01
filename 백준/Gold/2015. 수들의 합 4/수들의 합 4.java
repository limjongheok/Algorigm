import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];
        st = new StringTokenizer(br.readLine());

        // 누적합 구하기
        long count = 0;
        Map<Integer,Long> map = new HashMap<>();
        for(int i=1; i<=n; i++){
            arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
            if(arr[i] == k) {
                count++;
            }
            count += map.getOrDefault(arr[i] - k, 0L);
            map.put(arr[i],map.getOrDefault(arr[i],0L)+1);  //map 1 담김

        }
        System.out.println(count);


    }
}