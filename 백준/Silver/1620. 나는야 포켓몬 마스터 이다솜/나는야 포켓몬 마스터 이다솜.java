import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String,Integer> map = new HashMap<>();
        HashMap<Integer,String> map2 = new HashMap<>();
        for(int i=1; i<=n; i++){
            String s = br.readLine();
            map.put(s,i);
            map2.put(i,s);
        }

        for(int i =0; i<m; i++){
            String s = br.readLine();

            char c = s.charAt(0);
            if(c <=48 || c <=57 ){
                // 숫자

                System.out.println(map2.get(Integer.parseInt(s)));
            }else{
                // 문자
                System.out.println(map.get(s));
            }
        }

    }
}
