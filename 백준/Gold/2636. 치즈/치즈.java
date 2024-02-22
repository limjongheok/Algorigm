import java.io.*;
import java.util.*;
public class Main {
	private static int[][] arr;
	private static int n;
	private static int m;
	private static int[] dx = {0,0,1,-1};
	private static int[] dy = {1,-1,0,0};
	private static boolean[][] visited;
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		 n = Integer.parseInt(st.nextToken());
		 m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j]  = Integer.parseInt(st.nextToken()); // arr 채우기 
			}
		}
		visited = new boolean[n][m];
		bfs(0,0); // 밖 치즈 채우기 
		
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(!visited[i][j]) {
					if(arr[i][j] == 0) {
						bfs2(i,j); // 안쪽 빈칸 변경
					
					}
				}
			}
		}
		

	
		int count = 0;
		int nam = 0; // 나머지
		while(true) {
			int c = 0;
			
			boolean check = true;
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(arr[i][j] != 2) {
						check  = false;
					}
				
				}
			}
			
			
			if(check) { // 전부 2로 변경시 탈출 
				break; 
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(arr[i][j] == 1) {
						c++;
					}
				}
			}
			nam = c;
	
			for(int i=0; i<n; i++) { // 변경
				for(int j=0; j<m; j++) {
					if(arr[i][j]== 1) {
						// 상하 좌우 파악 하여 2 로 병경 
						change(i,j); // 공기랑 접척한 치즈 녹이기 0으로 변경
						
					
					}
				}
			}

		
			visited = new boolean[n][m];
		
			for(int i=0; i<n; i++) { // 녹은 치즈 및 안쪽 공기(3) 2로 변경하기 
				for(int j=0; j<m; j++) {
					if(!visited[i][j]) {
						if(arr[i][j] == 0) {
							bfs(i,j);
						}
					}
				}
			}
			
			count ++;
			
		

		}	
	
		System.out.println(count);
		System.out.println(nam);
		
	}
	
	private static void change(int x, int y) { // 공기랑 접촉 치즈 0으로 변경
		for(int i=0; i<4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			
			if(nextX >=0 && nextX < n) {
				if(nextY >=0 && nextY  <m) {
					   if(arr[nextX][nextY] == 2) {
						   if(arr[x][y] == 1) {
							   arr[x][y] = 0;
						   }
					   }
				}
			}
		}
	}
	
	private static void bfs(int x, int y) {	 // 밖공기 변경
		Node node = new Node(x,y);
		Queue<Node> queue = new LinkedList();
		queue.add(node);
		visited[x][y] = true;
		arr[x][y] = 2;
		
		while(!queue.isEmpty()) {
			Node nowNode = queue.poll();
			int nowX = nowNode.x;
			int nowY = nowNode.y;
			for(int i=0; i<4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				
				if(nextX >=0 && nextX < n) {
					if(nextY >=0 && nextY  <m) {
						if(!visited[nextX][nextY]) {
						   if(arr[nextX][nextY]==0 || arr[nextX][nextY] ==3) { // 밖공기 다음 0 3 일시 녹이기
							   visited[nextX][nextY] = true;
							   arr[nextX][nextY] = 2;
							   queue.add(new Node(nextX, nextY));
						   }
						}
						
					}
				}
			}
			
		}
		
	}
	
	
	private static void bfs2(int x, int y) { // 안쪽 공기 변경
		
		Node node = new Node(x,y);
		Queue<Node> queue = new LinkedList();
		queue.add(node);
		visited[x][y] = true;
		arr[x][y] = 3;
		
		while(!queue.isEmpty()) {
			Node nowNode = queue.poll();
			int nowX = nowNode.x;
			int nowY = nowNode.y;
			for(int i=0; i<4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				
				if(nextX >=0 && nextX < n) {
					if(nextY >=0 && nextY  <m) {
						if(!visited[nextX][nextY]) {
						   if(arr[nextX][nextY]==0) {
							   visited[nextX][nextY] = true;
							   arr[nextX][nextY] = 3;
							   queue.add(new Node(nextX, nextY));
						   }
						}
						
					}
				}
			}
			
		}
		
	}
	
	private static void print() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	
	private static class Node{
		int x;
		int y;
		public Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

}
