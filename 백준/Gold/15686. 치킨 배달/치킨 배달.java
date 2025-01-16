

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br;
	static StringTokenizer st;
	
	
	static int[][] map;
	static int n;
	static int m;
	static int 전체치킨집수;
	static int min = Integer.MAX_VALUE;
	
	static List<Node> 일저장;
	static List<Node> 이저장;
	
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = 초기화();

		전체치킨집수 = 이저장.size();
		boolean[] visited = new boolean[전체치킨집수];
		
		치킨집뽑기(0,0, visited);
		System.out.println(min);
		
	}
	
	private static int[][] 초기화() throws IOException {
		map = new int[n][n];

		일저장 = new ArrayList<Node>();
		이저장 = new ArrayList<Node>();
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;

				if(num == 1) {
					일저장.add(new Node(i,j));
				}
				if(num == 2) {
					이저장.add(new Node(i,j));
				}				
			}
		}
		
		return map;
	}
	
	
	/*
	 * // 치킨집 뽑기 
// 만약 1234 이면 
// 123 134 234 조합으로 뽑기 
// 즉 재귀를 돌아조합을 뽑는데 배열 치킨저장공간[]이 m면 멈추고
// 집에서 치킨집 으로 가는 탐색

// 3이 아니면 for문으로 현재 위치 로 시작해서 m까지 도는 포문을 돌고
// 현재 치킨집이 방문하지 않을시 
// 치킨집뽑기(i+1, 방문치킨+1)즉 나 다음 노드 탐색을 한다 
// 방문 제거 한다. 그럼 처음이 1 인노드 돌고 그다음 2가 시작인게 올수 있다. (방문탐색해야 123 132 가 안됨) 

	 */
	private static void 치킨집뽑기(int count,int 시작지점, boolean[] visited) {
	
		if(count == m) {
			집에서치킨집으로(visited);
			return;
		}
		
		for(int i= 시작지점; i<전체치킨집수; i++) {
			if(!visited[i]) { // 해당 치킨집 방문하지 않을시
				visited[i] = true;
				치킨집뽑기(count+1, i+1, visited);
				visited[i] = false;	
			}
		}
	}
	
	
	//------
	//  치킨집에서 집으로 가는 탐색 (함수 )
	// 만약 모든치킨집을 다 돌면 멈춘다
	// 그리고 min sum  처리를 한다 
	private static void 집에서치킨집으로(boolean[] visited) {
		
		int sum = 0;
		for(int i=0; i<일저장.size(); i++) {
			
			Node 집 = 일저장.get(i);
			int count = 치킨집으로부터1탐색(집, visited);
			
			sum = sum+count;
			// 계산을 다 하지 않았는데 sum 이 min 보다 클시 멈추기 
			if(sum > min) {
				break;
			}
		}
		
		if(sum < min) {
			min = sum;
		}
		
	}
	
	
	private static int 치킨집으로부터1탐색(Node node, boolean[] 선택치킨집) {
		
		int x = node.x;
		int y = node.y;
		
		int count = Integer.MAX_VALUE;
		for(int i=0; i<선택치킨집.length; i++) {
			if(선택치킨집[i]) {
				Node 치킨집 = 이저장.get(i);
				
				count = Math.min(Math.abs(x-치킨집.x)+ Math.abs(y-치킨집.y), count);
			}
		}

		return count;
		
	}

}

class Node {
	int x;
	int y;
	
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}