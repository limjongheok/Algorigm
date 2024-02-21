import java.io.*;
import java.util.*;

public class Main {
	private static int[][] arr;
	private static int[][] copyArr;
	private static int n;
	private static int m;
	private static boolean[][] visited;
	private static boolean[][] countVisited;
	private static int[] dx = {0,0,1,-1};
	private static int[] dy = {1,-1,0,0};
	private static int max;
	private static int counts;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		 n = Integer.parseInt(st.nextToken());
		 m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		copyArr = new int[n][m];
		// 입력 
		 for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			 for(int j=0; j<m; j++) {
				 arr[i][j] = Integer.parseInt(st.nextToken());
			 }
		 }


		 
		 max = Integer.MIN_VALUE;
		 dfs(0);
		 System.out.println(max);
		
	}
	
	private static void dfs(int count) { // 벽 세우기 
		
	
	
	
		
		if(count == 3) { //벽세우기 
		
			visited = new boolean[n][m];
			// arr 최대 안전 영역 크기 출력
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					copyArr[i][j] = arr[i][j];
				}
			} // 감염
			
		
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(!visited[i][j]) {
						if(copyArr[i][j] == 2) {
							bfs(i,j);
						}
					}
				}
			}
		
	
		
			// count 
			int counts = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(copyArr[i][j] == 0) {
						counts++;
					}
				
				}
			}
			max = Math.max(counts, max);
		return;
			
			
			
		}
		
		for(int i=0; i<n; i++) { // 벽 세우기 
			for(int j=0; j<m; j++) {
				if(arr[i][j] == 0) {
					arr[i][j] = 1;
					dfs(count+1);
					arr[i][j] = 0;
				}
			}
		}
		
		
	}
	
	
	
	private static void bfs(int x, int y) {
		Node node = new Node(x,y);
		
		Queue<Node> queue = new LinkedList();
		
		queue.add(node);
		
		while(!queue.isEmpty()) {
			Node nowNode = queue.poll();
			int nowX = nowNode.x;
			int nowY = nowNode.y;
			
			for(int i=0; i<4; i++) {
				int nextX = nowX+dx[i];
				int nextY = nowY +dy[i];
				
				if(nextX >=0 && nextX <n) {
					if(nextY >=0 && nextY <m) {
						if(!visited[nextX][nextY]) {
							if(copyArr[nextX][nextY] == 0) {
								copyArr[nextX][nextY] = 2;
								visited[nextX][nextY] = true;
								queue.add(new Node(nextX,nextY));
							}
						}
					}
				}
			}
		}
		
	}
	
	private static class Node{
		int x;
		int y;
		public Node(int x, int y) {
			this.x = x;
			this.y =y;
		}
	}
	
	private static void print() {
		for(int i = 0; i<n; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(copyArr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	private static void printA() {
		System.out.println("A");
		for(int i = 0; i<n; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}