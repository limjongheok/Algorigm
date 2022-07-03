import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static  void main(String[] args){

        Scanner sc = new Scanner(System.in);


        // 물 새는곳
        int water = sc.nextInt();
        // 테이프 길이
        int tapeL = sc.nextInt();
        int[] location = new int[water];


        // 물 새는 곳 위치
        for(int i=0; i<water; i++){
            location[i] = sc.nextInt();
        }



        // 물새는곳 위치 정렬
        Arrays.sort(location);

        // 확인
//        for (int i=0; i<water; i++){
//            System.out.println(location[i]);
//        }
        double left = location[0] - 0.5; 
        int count =1;
        for(int i=0; i< water; i++){
            // 시작 위치가
            if(left + tapeL< location[i]){
                count ++;
                left = location[i]-0.5;
            }
        }
        System.out.println(count);

    }
}