import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 입력 n 과일 개수 m 초기 길이
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n= Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n]; // 과일들
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken()); // 과일들 입력
        }

        Arrays.sort(arr); // 2. 과일 정렬

        for(int i=0; i<arr.length; i++){
            if(arr[i] <= m){
                // 과일 높이보다 길이가 크면 과일 먹고 증가
                m+=1;
            }else{
                // 과일 높이가 더 크면
                break;
            }
        }
        System.out.println(m);
    }
}