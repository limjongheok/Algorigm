import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int sum;
    static  int array[];

    static  int N;
    static  int M;


    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st ;
        st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        array = new int[N+1];

        st = new StringTokenizer(bf.readLine()); // 5 4 3 2 1
        for(int i=1; i<=N; i++){
            array[i] = array[i-1]+ Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<M;i++) {
            st=new StringTokenizer(bf.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            // a, b사이의 구간합은 array[b]-array[a-1]과 같다
            System.out.println(array[b]-array[a-1]);
        }

    }
}
