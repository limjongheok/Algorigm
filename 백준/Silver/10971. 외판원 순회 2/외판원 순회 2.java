import java.io.*;
import java.util.*;
public class Main {
		private static int n;
	private static int[][] arr;
	private static boolean[] visited;
	private static int min;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1][n+1];
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[n+1];
		int[] arr2 = new int[n+1];
		min = Integer.MAX_VALUE;
	    for(int i=1; i<=n; i++) {
	    	visited[i] = true;
	    	dfs(i,1,i,0);
	    	visited[i] = false;
	    }
		System.out.println(min);
		
	}
	
	private static void dfs(int first, int idx, int v , int count) {
		if(idx == n) { // n이면 종료 
			if(checkConnect(v,first)) {
				count+=arr[v][first];
				min = Math.min(count, min);
			}
			
			return;
		}
		
		for(int i=1; i<=n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				if(checkConnect(v,i)) {
					dfs(first,idx+1,i,arr[v][i] + count);
				}
				visited[i] = false;
				
			}
		}
	}
	
	private static boolean checkConnect(int v, int i) {
		
	    if(arr[v][i]!=0) {
	    	return true;
	    }
	    
	    return false;
		
	}
	

}
