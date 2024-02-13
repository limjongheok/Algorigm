import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // n 입력

        int min = Integer.MAX_VALUE;
        for(int i=0; i<=n/5; i++){
            for(int j=0; j<=n/3; j++){
                if((i*5 + j*3) == n){
                    min = Math.min(i+j,min);
                }
            }
        }
        if(min == Integer.MAX_VALUE){
            System.out.println(-1);
        }else {
            System.out.println(min);
        }


    }
}