import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());


        System.out.println(fact(n)/(fact(k)*fact(n-k)));



    }

    public static int fact(int n){
        if(n <= 1){
            return 1;
        }

        return n*fact(n-1);
    }
}