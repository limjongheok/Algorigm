
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;

    static int k; // 기존 랜선 개수
    static int n; // 필요한 랜선 개수

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        int[] arr = 배열만들기(k);

        long maxNum = arr[k - 1]; // 배열의 최대값
        long minNum = 1; // 최소값은 1로 설정

        long 값 = 값구하기(minNum, maxNum, arr);

        System.out.println(값);
    }

    private static int[] 배열만들기(int k) throws IOException {
        int[] arr = new int[k];

        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr); // 오름차순 정렬

        return arr;
    }

    private static long 값구하기(long minNum, long maxNum, int[] arr) {
        // 종료 조건
        if (minNum > maxNum) {
            return maxNum; // 최적의 랜선 길이 반환
        }

        long mid = (minNum + maxNum) / 2;
        long 합계 = 합계구하기(arr, mid);

        if (합계 >= n) { // 조건을 만족하면 더 큰 길이를 탐색
            return 값구하기(mid + 1, maxNum, arr);
        } else { // 조건을 만족하지 못하면 더 작은 길이를 탐색
            return 값구하기(minNum, mid - 1, arr);
        }
    }

    private static long 합계구하기(int[] arr, long mid) {
        long 합계 = 0;

        for (int i = 0; i < arr.length; i++) {
            합계 += arr[i] / mid;
        }

        return 합계;
    }
}

