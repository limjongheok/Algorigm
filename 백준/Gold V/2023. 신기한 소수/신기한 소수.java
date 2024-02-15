import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[] arr;
    private static int n;
    private static int[] printArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine()); // n 자리

       // 1. 1의 자리 소수
        // 2 3  5 7 9

      arr = new int[]{2,3,5,7};

      sol(0, "");


    }

    private static void sol(int idx, String s){

        if(idx == n){
            System.out.println(s);
            return;
        }


        for(int i=1; i<=9; i++){
            if(checkS(s,i)){ // 소수 일시
                //System.out.println(arr[i]);
                sol(idx+1,s+i);
            }
        }
    }

    private static boolean checkS(String s, int num){

        s = s+num;
        int n = Integer.parseInt(s);

        if(s.length()==1){
            if(n!=2 && n!=3 && n!=5 && n!=7){
                return false;
            }
        }
        // 소수 찾기
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n % i == 0) { // 소수
                return false;
            }
        }
        return true;
    }
}