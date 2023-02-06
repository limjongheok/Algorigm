import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static  int N;
    static  int[] arr;
    static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        arr = new int[N+1];

        Nqueen(0);


        System.out.println(count);



    }

    public  static  void Nqueen(int n){

        if(n == N){ // 모든 열을 다 돌았을때
            count ++;
            return; // 종료

        }

        for(int i=0; i<N; i++){
            arr[n] = i;
            if(posibility(n)){
                Nqueen(n+1);
            }

        }
    }


    // 검증
    public static  boolean posibility(int i){
        for(int j=0; j<i; j++){
            if(arr[i] == arr[j]){
                return false;
            } else if (Math.abs(i-j)== Math.abs(arr[i]-arr[j])) {
                return false;

            }
        }
        return true;

    }
}
