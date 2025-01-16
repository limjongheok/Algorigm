import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 *
문제
상근이는 요즘 설탕공장에서 설탕을 배달하고 있다.
상근이는 지금 사탕가게에 설탕을 정확하게 N킬로그램을 배달해야 한다.
설탕공장에서 만드는 설탕은 봉지에 담겨져 있다.
 봉지는 3킬로그램 봉지와 5킬로그램 봉지가 있다.
상근이는 귀찮기 때문에, 최대한 적은 봉지를 들고 가려고 한다.
 예를 들어, 18킬로그램 설탕을 배달해야 할 때, 3킬로그램 봉지 6개를 가져가도 되지만, 5킬로그램 3개와 3킬로그램 1개를 배달하면,
  더 적은 개수의 봉지를 배달할 수 있다.
상근이가 설탕을 정확하게 N킬로그램 배달해야 할 때, 
봉지 몇 개를 가져가면 되는지 그 수를 구하는 프로그램을 작성하시오.
 */

//문제 풀이 
// dp = int[18] 이다 
// 그리고 dp[x] 가 0 이되면 return 한다
// 만약 0보다 작아져도 리턴한다 

// dp[x] = min(dp[x-3] +1, dp[x-5] +1) 한 형식이다 
//즉 밑에거 부터 채우며 저장 
public class Main {
	
	static BufferedReader br;
	
	static int[] dp;

	
	public static void main(String[] args) throws IOException{
		
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		dp = new int[n + 1];

        // -1로 초기화하여 계산되지 않은 상태를 표시
        for (int i = 0; i <= n; i++) {
            dp[i] = -1;
        }
		
		int 봉지개수 = 봉지구하기(n);
		
		if(봉지개수> 6000) {
			System.out.println(-1);
		}else {
			System.out.println(봉지개수);
		}

	}
	
	private static int 봉지구하기(int n) {
		if(n == 3 || n == 5) {
			
			return 1;
		}
		
		if (n<3) {
			return 99988;
		}
		
		if(dp[n] != -1) {
			return dp[n];
		}
		
		dp[n] = Math.min(봉지구하기(n-3) + 1, 봉지구하기(n-5) +1);
		return dp[n];
		
	}
	

}
