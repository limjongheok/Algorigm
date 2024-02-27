import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int[][] arr;
	static int[][] copy;
	static List<Node> list;
	private static int size;
	private static boolean[] visited;
	private static int[] dx = {1,-1};
	private static int[] dy = {-1,1};
	static int n;
	static int m;
	static int min;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		 n = Integer.parseInt(st.nextToken());
		 m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		
		
        list = new ArrayList();
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] !=0 && arr[i][j] !=6 ) {
					list.add(new Node(i,j,arr[i][j],0));
				}
				
			}
		}
		 size = list.size();
		 visited = new boolean[size];
		Node[] node = new Node[size];
		min = Integer.MAX_VALUE;
		
		dfs(0,0,node);
		System.out.println(min);
		
		
	}
	private static void dfs(int idx, int v, Node[] node) {
		
		if(idx == size) {
			// 감시하기 
			copy();
			watch(node);
			result();
		}
		
		for(int i=v; i<list.size(); i++) {
			if(!visited[i]) {
				visited[i] = true;
				Node n = list.get(i);
				if(n.num ==1 || n.num ==2 || n.num ==3 || n.num == 4) {
					for(int j=0; j<4; j++) {
						n.status = j;
						node[idx] = n;
						dfs(idx +1 ,i+1, node);
						visited[i] = false;
					}
				}else{
					node[idx] = n;
					dfs(idx +1 ,i+1, node);
					visited[i] = false;
				}
				
				
			}
			
		}
	}
	
	private static void result() {
		int cnt = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(copy[i][j] == 0) {
					cnt++;
				}
			}
			
		}

		min = Math.min(cnt, min);
		
	}
	
	private static void watch(Node[] node) {
		for(Node n : node) {
			int nowX = n.x;
			int nowY = n.y;
			int nowNum = n.num;
			int nowStats = n.status;
			
			
			if(nowNum == 1) {
				if(nowStats == 0) {
					// 왼쫏
					right(nowX,nowY);
				}else if(nowStats == 1) {
					down(nowX,nowY);
				}else if(nowStats == 2) {
					left(nowX,nowY);
				}else if(nowStats == 3) {
					up(nowX,nowY);
				}
				
				
			}else if(nowNum ==2) {
				if(nowStats == 0) {
					// 왼쫏
					left(nowX,nowY);
					right(nowX,nowY);
				}else if(nowStats == 1) {
					up(nowX,nowY);
					down(nowX,nowY);
				}else if(nowStats == 2) {
					left(nowX,nowY);
					right(nowX,nowY);
				}else if(nowStats == 3) {
					up(nowX,nowY);
					down(nowX,nowY);
				}
				
			}else if(nowNum == 3) {
				if(nowStats == 0) {
					// 왼쫏
					up(nowX,nowY);
					right(nowX,nowY);
				}else if(nowStats == 1) {
					right(nowX,nowY);
					down(nowX,nowY);
				}else if(nowStats == 2) {
					left(nowX,nowY);
					down(nowX,nowY);
				}else if(nowStats == 3) {
					left(nowX,nowY);
					up(nowX,nowY);
				}
				
			}else if(nowNum == 4) {
		
				if(nowStats == 0) {
					// 왼쫏
					up(nowX,nowY);
					right(nowX,nowY);
					left(nowX,nowY);
				}else if(nowStats == 1) {
					up(nowX,nowY);
					right(nowX,nowY);
					down(nowX,nowY);
				}else if(nowStats == 2) {
					left(nowX,nowY);
					right(nowX,nowY);
					down(nowX,nowY);
				}else if(nowStats == 3) {
					up(nowX,nowY);
					left(nowX,nowY);
					down(nowX,nowY);
				}
		
			}else {
				// 왼쫏
				left(nowX,nowY);
				up(nowX,nowY);
				right(nowX,nowY);
				down(nowX,nowY);
			}
			
		}
		
	}
	
	private static void left(int x, int y) {
		// 왼쪽
		while(true) {
			 y = dy[0] + y;
			 if(y >=0 && y<m) {
				 if(copy[x][y] == 0 || copy[x][y] == 7) {
					 copy[x][y] = 7;
				 }
				 if(copy[x][y] == 6) {
					 return;
				 }
			 }else {
				 return;
			 }
		}
	}
	
	private static void right(int x, int y) {
		// 왼쪽
		while(true) {
			 y = dy[1] + y;
			 if(y >=0 && y<m) {
				 if(copy[x][y] == 0 || copy[x][y] == 7) {
					 copy[x][y] = 7;
				 }
				 if(copy[x][y] == 6) {
					 return;
				 }
			 }else {
				 return;
			 }
		}
	}
	
	private static void up(int x, int y) {
		// 왼쪽
		while(true) {
			 x = dx[1] + x;
			 if(x >=0 && x<n) {
				 if(copy[x][y] == 0 || copy[x][y] == 7) {
					 copy[x][y] = 7;
				 }
				 if(copy[x][y] == 6) {
					 return;
				 }
			 }else {
				 return;
			 }
		}
	}
	
	private static void down(int x, int y) {
		// 왼쪽
		while(true) {
			 x = dx[0] + x;
			 if(x >=0 && x<n) {
				 if(copy[x][y] == 0 || copy[x][y] == 7) {
					 copy[x][y] = 7;
				 }
				 if(copy[x][y] == 6) {
					 return;
				 }
			 }else {
				 return;
			 }
		}
	}
	
	private static void copy() {
		copy = new int[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				copy[i][j] = arr[i][j];
			}
		}
	}
	
	
	
	private static class Node{
		int x;
		int y;
		int num;
		int status;
		public Node(int x, int y,int num, int status) {
			this.x =x;
			this.y=y;
			this.num =num;
			this.status= status;
		}
	}
	
	private static void print() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(copy[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
