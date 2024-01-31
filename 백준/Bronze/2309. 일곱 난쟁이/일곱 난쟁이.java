import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[9];

        int sum = 0;
        for(int i=0; i<9; i++){
            arr[i] = Integer.parseInt(br.readLine());

            sum += arr[i];
        }

        Arrays.sort(arr);
        sum = sum-100;
        int start = 0;  // 시작점
        int end = arr.length-1; // 끝점

        // 두개를 빼면됨  sum 에 해당하는

        while(start<=end){

            int arrSum = arr[start] +arr[end];
            if(arrSum > sum){
                end = end-1;
            } else if (arrSum<sum) {
                start = start+1;
            }
            if(sum == arrSum){
                break;
            }
        }

        for(int i=0; i<9; i++){
            if(i!=start && i!=end){
                System.out.println(arr[i]);
            }

        }

    }
}