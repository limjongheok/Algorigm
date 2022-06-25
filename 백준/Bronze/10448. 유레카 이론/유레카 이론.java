import java.util.Scanner;

public class Main {

    public static void result(int testcase){
        for(int j=0; j<triangle.length; j++){
            for(int k=0; k< triangle.length; k++){
                for(int l=0; l< triangle.length; l++){
                    if(testcase == triangle[j]+triangle[k]+triangle[l]){
                        
                        System.out.println(1);
                        return  ;
                    }

                }
            }
            
           
        }
        System.out.println(0);
    }

    static int[] triangle = new int[1000];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        triangle[0] = 1;
        int plus = 2;
        // 전체 삼각형 구하기  n 시간
        for (int i = 1; i < 1000; i++) {
            triangle[i] = triangle[i - 1] + plus;
            plus = plus + 1;


        }
        int input = sc.nextInt();
        for(int i=0; i<input; i++){
            int testcase = sc.nextInt();
            result(testcase);
        }
    }
}