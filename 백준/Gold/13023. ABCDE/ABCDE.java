

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * BOJ 알고리즘 캠프에는 총 N명이 참가하고 있다. 
 * 사람들은 0번부터 N-1번으로 번호가 매겨져 있고, 일부 사람들은 친구이다.
 * 오늘은 다음과 같은 친구 관계를 가진 사람 A, B, C, D, E가 존재하는지 구해보려고 한다.
 * A는 B와 친구다.
 * B는 C와 친구다.
 * C는 D와 친구다.
 * D는 E와 친구다.
 * 위와 같은 친구 관계가 존재하는지 안하는지 구하는 프로그램을 작성하시오.
 * 
 * 입력
 * 첫째 줄에 사람의 수 N (5 ≤ N ≤ 2000)과 친구 관계의 수 M (1 ≤ M ≤ 2000)이 주어진다.
 * 둘째 줄부터 M개의 줄에는 정수 a와 b가 주어지며, 
 * a와 b가 친구라는 뜻이다. (0 ≤ a, b ≤ N-1, a ≠ b)
 *  같은 친구 관계가 두 번 이상 주어지는 경우는 없다.
 */

// 풀이 
// 입력 n 과 m 을 받는다 
// m은 정점 수 고 n은 반복 
// 연결리스트만들기()
// visited[m] 이며 시작점은 연결리스트.get(0).get(0)이다
// dfs(연결리스트, visited, 시작지점)
// 답구하기(visited)

//---- 연결 리스트 만들기
// n 번만큼 반복하는 연결리스트 만든다. 
// 

//----- dfs(연결리스트, 방문, 현재)
// 방문에서 현재= true 한다 
// 연결리스트로 다음 방문을 탐색한다 
// 만약 다음 방문이 false 이면 
// dfs(연결리스트, 방문, 다음) 을 진행한다. 


//--- 답구하기 (visited)
// for visited 의 length 만큼 돌면서
// 만약 false 방문하지 않는 점이 나오면 state true로 한후 멈추기 // 방문 안한 노드가 존재하니까
// state 가 true 면 0 아니면 1을 출력한다. 
public class Main {
	
	static BufferedReader br;
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int 차수 = Integer.MIN_VALUE;
	static boolean found;
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		List<List<Integer>> 연결리스트 = 연결리스트만들기();
		
	

		
		for(int i=0; i<N; i++) {
			boolean[] visited = new boolean[N];
			dfs(연결리스트,visited, i,0);
		}
		
		
		답구하기();
	}
	
	private static List<List<Integer>> 연결리스트만들기() throws IOException {
		List<List<Integer>> 연결리스트 = new ArrayList();
		
		for(int i=0; i<=N; i++) {
			List<Integer> list = new ArrayList<Integer>();
			연결리스트.add(list);
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int one = Integer.parseInt(st.nextToken());
			int two = Integer.parseInt(st.nextToken());
			
			연결리스트.get(one).add(two);
			연결리스트.get(two).add(one);
		}
		
		return 연결리스트;
	}
	
	//----- dfs(연결리스트, 방문, 현재)
	// 방문에서 현재= true 한다 
	// 연결리스트로 다음 방문을 탐색한다 
	// 만약 다음 방문이 false 이면 
	// dfs(연결리스트, 방문, 다음) 을 진행한다. 
	// 차수를 구함 차수는 정점총 수 -1 이어야함 

	private static void dfs(List<List<Integer>> 연결리스트, boolean[] visited, int start, int count) {
		
		
		if(count == 4) {
			found =true;
		}
		visited[start] = true;
		
		
		for(int i=0; i<연결리스트.get(start).size(); i++) {
			int 다음노드 = 연결리스트.get(start).get(i);
			
			if(!visited[다음노드]) {
				dfs(연결리스트, visited, 다음노드, count +1);
				if(found) return;
			}
		}
		
		visited[start] = false;
	}
	
	private static void 답구하기() {
		if(found) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
	}
	

}
