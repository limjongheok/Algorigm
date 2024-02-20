import java.io.*;
import java.util.StringTokenizer;


public class Main {
	private static boolean[] visited;
	private static int[] dx =  {1,-1,0,0};
	private static int[] dy = {0,0,1,-1};
	private static char[][] arr;
	private static int n;
	private static int m;
	private static int max;
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		visited= new boolean[27]; // 알파벳 방문 배열 
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		 n = Integer.parseInt(st.nextToken());
		 m = Integer.parseInt(st.nextToken());
		
		arr = new char[n][m];
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j =0; j<m; j++) {
				arr[i][j] = s.charAt(j);
				visited[arr[i][j]-65] = true;
			}
		}
		max = Integer.MIN_VALUE;
		visited[arr[0][0]-65] = false;
		dfs(0,0, 0);
		System.out.println(max+1);
		
		
	}
	
	private static void dfs(int x, int y , int count  ) {
		
		
		
		for(int i=0; i<4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			
			if(nextX >=0 && nextX <n ) {
				if(nextY >=0 && nextY <m) {
					if(visited[arr[nextX][nextY]-65]) {
						visited[arr[nextX][nextY]-65] = false;
						dfs(nextX,nextY,count+1);
						visited[arr[nextX][nextY]-65] = true;
					}
				}
			}
		}
		
		max = Math.max(max, count);
		
		
		
		
		
	}
	

}
