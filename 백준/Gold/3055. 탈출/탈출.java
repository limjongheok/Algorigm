import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static char[][] arr ;
	static Queue<Node> queue1 = new LinkedList();
	static Queue<Node> queue2 = new LinkedList();
	static boolean[][] visited;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	private static int n;
	private static int m;
	private static boolean check;
	private static int count;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		 n = Integer.parseInt(st.nextToken());
		 m = Integer.parseInt(st.nextToken());
		
		arr = new char[n][m];
		
		visited = new boolean[n][m];
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<m; j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		
		for(int i=0; i<n; i++) {
		    for(int j=0; j<m; j++) {
		    	if(arr[i][j] == 'S') {
		    		queue1.add(new Node(i,j));
		    	}
		    	if(arr[i][j] ==  '*') {
		    		queue2.add(new Node(i,j));
		    	}
		    }
		}
		check = false;
		count = 0;
		bfs();
		if(check) {
			System.out.println(count);
		}else {
			System.out.println("KAKTUS");
		}
		
		
		
	}
	
	private static void bfs() {
		while(!queue1.isEmpty()) { 
			int size = queue1.size();
			
			int waterSize = queue2.size();
			for(int j=0; j<waterSize; j++) { // 물채우기 
				// 물 채우기 
				Node waterNode = queue2.poll();
				int waterX = waterNode.x;
				int waterY = waterNode.y;
				for(int z=0; z<4; z++) {
					int nextX = waterX + dx[z];
					int nextY = waterY + dy[z];
					if(nextX >= 0 && nextX <n) {
						if(nextY >=0 && nextY  <m) {
							if(!visited[nextX][nextY]) {
								if(arr[nextX][nextY] == '.') {
									visited[nextX][nextY] = true;
									arr[nextX][nextY] =  '*';
									queue2.add(new Node(nextX,nextY));
								}
							}
						}
					}
				}
				
			}
			for(int i=0; i<size; i++) {
				Node goNode = queue1.poll();
				int goX = goNode.x;
				int goY = goNode.y;
				
				// 고슴도치 채우기 
				for(int z=0; z<4; z++) {
					int nextX = goX + dx[z];
					int nextY = goY + dy[z];
					
					if(nextX >= 0 && nextX <n) {
						if(nextY >=0 && nextY  <m) {
							if(!visited[nextX][nextY]) {
								if(arr[nextX][nextY] == '.') {
									visited[nextX][nextY] = true;
									arr[nextX][nextY] =  'S';
									queue1.add(new Node(nextX,nextY));
								}
								else if(arr[nextX][nextY] == 'D') {
									count++;
									check = true;
									return ;
								}
							
							}
						}
					}
				}
			
			}

			count++;
			
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
		public Node(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}

}
