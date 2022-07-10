import java.util.Scanner;

public class Main {
    static  int NUM;
    static int blueray;

    static  int[] arr;
    static  int left;
    static  int right;
    static int count;
    static int m;


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        NUM = sc.nextInt();
        blueray = sc.nextInt(); // 3

        arr= new int[NUM];
        for(int i=0; i<NUM; i++){
            arr[i] = sc.nextInt();
            right = right +arr[i];
            left = left < arr[i] ? arr[i] : left;
        } //45

        System.out.println(lowerbound(left,right));

    }

    private static int lowerbound(int left, int right) {

        while(left<=right){  // left 9 right 45
            int mid = (left +right)/2; //54
            int sum = 0;
            count =0;

            for(int i=0; i<NUM; i++) {
                if(sum + arr[i] > mid) {
                    sum = 0;
                    count++;
                }
                sum += arr[i];
            }

            if(sum != 0){
                count++;
            }
            if(count > blueray){
                left = mid+1;
            }
            else{
                right = mid-1;
            }


        }
        return left;

    }
}
