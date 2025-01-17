import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	128 MB	315287	125352	74172	38.324%
문제
그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.
 */

//풀이 
// 인접 리스트 생성 인접리스트는 리스트속 리스트 
//dfs
//bfs
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
		int v = Integer.parseInt(st.nextToken());
		
		List<List<Integer>> list = 인접리스트만들기();
		리스트값추가(list);
		
		boolean[] visited = new boolean[n+1];
		StringBuilder sb = new StringBuilder();
		dfs(list, visited, sb, v);
		
		System.out.println(sb);
		
		visited = new boolean[n+1];
	    sb = new StringBuilder();
	    
	    bfs(list, visited, sb, v);
	    System.out.println(sb);
	}
	
	private static List<List<Integer>> 인접리스트만들기() {
		
		List<List<Integer>> 인접리스트 = new ArrayList<List<Integer>>();
		
		for(int i=0; i<=n; i++) {
			List<Integer> 이너리스트 = new ArrayList<Integer>();
			인접리스트.add(이너리스트);
		}
		
		return 인접리스트;		
	}
	
	private static void 리스트값추가(List<List<Integer>> list) throws IOException {
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		for(int i=0; i<=n; i++) {
			list.get(i).sort(null);
		}
	}
	
	private static void dfs(List<List<Integer>> list, boolean[] visited, StringBuilder sb, int v) {
		
		visited[v] = true; // 방문 
		sb.append(v + " ");
		
		for(int i=0; i<list.get(v).size(); i++) {
			if(!visited[list.get(v).get(i)]) { // 방문하지 않았으면
				dfs(list,visited, sb, list.get(v).get(i));
			}
		}
		
	}
	
	private static void bfs(List<List<Integer>> list, boolean[] visited, StringBuilder sb, int v) {
		
		visited[v] = true;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(v);
		sb.append(v + " ");
		
		while(!queue.isEmpty()) {
			int n = queue.poll();
			
			for(int i=0; i<list.get(n).size(); i++) {
				int next = list.get(n).get(i);
				if(!visited[next]) {
					visited[next] = true;
					sb.append(next+ " ");
					queue.add(next);
				}
			}
		}
			
		
	}

}
