import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        re(m,0);

    }
    private static void re(int num, int count){
        if(num==n){
            System.out.println(count+1);
            return;
        }
        if(num < n){
            System.out.println(-1);
            return;
        }

        String sNum = String.valueOf(num);
        if(num%2==0){
            re(num/2,count+1);
        } else{
            if(sNum.charAt(sNum.length()-1) == '1'){
                int n = Integer.parseInt(sNum.substring(0,sNum.length()-1));
                re(n,count+1);
            }else{
                System.out.println(-1);
                return;
            }
        }

    }
}
