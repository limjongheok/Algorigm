import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static int firstNumarr[];
    static int getNumberarr[];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        firstNumarr = new int[N];
        // 처음 가지고 있는 카드
        for(int i=0; i<N; i++){
            firstNumarr[i] = sc.nextInt();
        }

//        // 확인
//        for(int i=0; i<N; i++){
//            System.out.println(firstNumarr[i]);
//        }
        Arrays.sort(firstNumarr); // n log n


        M = sc.nextInt();
        getNumberarr = new int[M];

        StringBuilder sb = new StringBuilder();
        // 뽑아서 노온 배열
        for(int i=0; i<M; i++){
            getNumberarr[i] = sc.nextInt();
            int key = getNumberarr[i];

            sb.append(binaraySearchupper(key)-binaraySearchlow(key)).append(' ');

        }
        System.out.println(sb);
        /////////////////////////////////








    }


    private static int binaraySearchupper(int key) {
        int lo =0 ;
        int hight = firstNumarr.length;

        while(lo<hight){
            int mid = (lo+hight)/2;
            if(key < firstNumarr[mid]){ // 현재 값이 mid 보다 작을시
                hight = mid;

            }
            else{
                lo = mid+1;
            }

        }
        return lo;
    }

    private static int binaraySearchlow(int key) {
        int lo =0 ;
        int hight = firstNumarr.length;

        while(lo<hight){
            int mid = (lo+hight)/2;
            if(key <= firstNumarr[mid]){ // 현재 값이 mid 보다 작을시
                hight = mid;

            }
            else{
                lo = mid+1;
            }

        }

        return lo;
    }
}
