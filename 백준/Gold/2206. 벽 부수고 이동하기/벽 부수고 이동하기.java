import java.io.*;
import java.util.*;

public class Main {
	private static int[][] arr;
	private static int[][] arr2;
	private static boolean[][] visited;
	private static boolean[][] visited2;
	private static int n;
	private static int m;
	private static int[] dx = {0,0,1,-1};
	private static int[] dy = {1,-1,0,0};
	private static boolean checked;
	public static void main(String[] args) throws IOException{
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in ));
		
		StringTokenizer st;
		
		
		st = new StringTokenizer(br.readLine());
		 n = Integer.parseInt(st.nextToken());
		 m = Integer.parseInt(st.nextToken());
		
		
		arr =new int[n][m];
		arr2 =new int[n][m];
		visited = new boolean[n][m];
		visited2 = new boolean[n][m];
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
				arr2[i][j] =  Integer.parseInt(String.valueOf(s.charAt(j)));
			}
		}
		
		bfs(0,0,true); // true 면 벽 부순적 없음
		if(!checked) {
			System.out.println(-1);
		}
		

		
	
	}
	
	private static void bfs(int x, int y, boolean check) {
		visited[x][y] = true;
		
		Node node = new Node(x,y,check,1);
		Queue<Node> queue = new LinkedList();
		
		queue.add(node);
		
		while(!queue.isEmpty()) {
			Node nowNode= queue.poll();
			int nowX = nowNode.x;
			int nowY = nowNode.y;
			boolean nowCheck = nowNode.check;
			
			if(nowX == n-1 && nowY  == m-1) {
				System.out.println(nowNode.num);
				checked = true;
				return;
			}
			
			for(int i=0; i<4; i++) {
				int nextX = nowX +dx[i];
				int nextY = nowY +dy[i];
	
				if(nextX >=0&& nextX <n) {
					if(nextY>=0 && nextY<m) {
						if(nowCheck) { // 벽을 부순 경우가 없는 경우 
					

							if(!visited[nextX][nextY]) {
								if(arr[nextX][nextY] == 0) {
									// 방문 
									visited[nextX][nextY] = true;
									queue.add(new Node(nextX,nextY,nowCheck,nowNode.num+1));
								}else { // 1 이면 
									
								 
										if(!visited2[nextX][nextY]) {
											boolean nextCheck = false; // 벽 부수고 
											visited2[nextX][nextY] = true;
											queue.add(new Node(nextX,nextY,nextCheck,nowNode.num+1)); // 다음 노드 탐색
						
										}
										
								
									
								}
								
							}
						}else {
							//System.out.println(nextX + " " + nextY);
							if(!visited2[nextX][nextY]) {
								if(arr[nextX][nextY] == 0) {
									// 방문 
									visited2[nextX][nextY] = true;
								
									queue.add(new Node(nextX,nextY,nowCheck,nowNode.num+1));
								}
							
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
	public static class Node{
		int x;
		int y;
		boolean check; // 벽 상태 체크 
		int num;
		
		public Node(int x, int y, boolean check, int num) {
			this.x = x;
			this.y = y;
			this.check = check;
			this.num = num;
		}
	}
	
	

}