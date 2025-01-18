import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br;
	static StringTokenizer st;
	
	static int n;
	static int m;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		int[] arr = 배열만들기(n);
		
		long maxNum = arr[n-1];
		long minNum = 1;
		
		long 값 = 값구하기(minNum , maxNum, arr);
		
		System.out.println(값);
	}
	
	private static int[] 배열만들기(int n) throws IOException {
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		return arr;
	}
	
	///----
	// 그럼 max와 1 을 이용해서 중간값을 구한다 
	// 해당 중간값을 배열을 순회하면 몇개로 구할수 있는지 구한다 .
	// 만약 현재 중간값을 이용해 구한값이 m 보다 크다면 시작지점을 mid +1 로 옮긴다. 
	// 아니면 end 를 mid  -1 로 옮긴다. // 몇개를 구해도 더 큰값이 있을수 있기 때문 즉 m 개로 구할수 있는 최대 랜선 길이가 있을 수 있기 때문 
	// 만약 시작지점이 end보다 크거나 같으면 끝낸다.
	private static long 값구하기(long minNum, long maxNum, int[] arr) {
		
		if(minNum >maxNum) {
			return maxNum;
		}
		
		long mid = (minNum + maxNum) / 2;
		
		long 합계 = 합계구하기(arr, mid);
		
		if(합계 <m) { //  mid를 줄여야함 
			return 값구하기(minNum, mid-1, arr);
		}else { // mid를 늘려야함
			return 값구하기(mid+1, maxNum, arr);
		}
		
	}
	
	private static long 합계구하기(int[] arr, long mid) {
		
		long 합계 = 0;
		
		// mid 길이만큼 구할때 몇개를 구할것인가 
		for(int i=0; i<n; i++) {
			합계 += arr[i]/mid;	
		}
		
		return 합계;
	}

}

