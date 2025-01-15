import java.io.*;
import java.util.*;

/*
 * 카지노에서 제일 인기 있는 게임 블랙잭의 규칙은 상당히 쉽다. 
 * 카드의 합이 21을 넘지 않는 한도 내에서, 카드의 합을 최대한 크게 만드는 게임이다.
 *  블랙잭은 카지노마다 다양한 규정이 있다.
 *  한국 최고의 블랙잭 고수 김정인은 새로운 블랙잭 규칙을 만들어 상근, 창영이와 게임하려고 한다.
 *  김정인 버전의 블랙잭에서 각 카드에는 양의 정수가 쓰여 있다.
 *  그 다음, 딜러는 N장의 카드를 모두 숫자가 보이도록 바닥에 놓는다.
 *  그런 후에 딜러는 숫자 M을 크게 외친다.
 *  이제 플레이어는 제한된 시간 안에 N장의 카드 중에서 3장의 카드를 골라야 한다.
 *  블랙잭 변형 게임이기 때문에, 플레이어가 고른 카드의 합은 M을 넘지 않으면서 M과 최대한 가깝게 만들어야 한다.
 *  N장의 카드에 써져 있는 숫자가 주어졌을 때, M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 구해 출력하시오.
 *  
 *  
 *  입력
 *  첫째 줄에 카드의 개수 N(3 ≤ N ≤ 100)과 M(10 ≤ M ≤ 300,000)이 주어진다. 
 *  둘째 줄에는 카드에 쓰여 있는 수가 주어지며, 이 값은 100,000을 넘지 않는 양의 정수이다.
 *  합이 M을 넘지 않는 카드 3장을 찾을 수 있는 경우만 입력으로 주어진다.
 */

// 풀이 
// n 개중 3개를 뽑을건데 이전에 뽑지 않을 걸 뽑을거
// 그러기 위해 
// 3번뽑음 멈추기 
// 현재 뽑은거 방문 시키고 다음 꺼 뽑기 근데 방문점 뽑음 x 그리고 합이 m 넘음 안됨

// 해서 3 개 하면 max 하기 근데 
public class Main {
	
	static BufferedReader br;
	static StringTokenizer st;
	static int[] cardArr;
	static int n;
	static int m;
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
	    cardArr = 카드배열생성(n);
	
		
		for(int i=0; i<n; i++) {
			boolean[] visited = new boolean[n];
			카드뽑기(0,visited, i, 0);
		}
		
		System.out.println(max);
		
	}
	
	private static int[] 카드배열생성(int n) throws IOException {
		int[] cardArr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			cardArr[i] = Integer.parseInt(st.nextToken());
		}
		
		return cardArr;
		
	}
	
	private static void 카드뽑기(int 뽑은수, boolean[] visited, int 시작수, int 합) {
		
		if(뽑은수 == 3) { // 3장 뽑음 멈춤
			
			if(합 > max) {
				max = 합;
			}
			return;
		}
		
		for(int i = 시작수; i<n; i++) { // 시작수 부터 시작해서 n 까지 돌건데 방문하지 않을때만할거임 
			if(!visited[i]) {
				int sum = 합 + cardArr[i];
				if(sum <= m) {
					visited[i] = true;
					카드뽑기(뽑은수+1, visited, i, sum);
					visited[i] = false;
				}
			}
			
		}
	}

}
