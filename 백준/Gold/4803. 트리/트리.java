import java.io.*;
import java.util.*;

public class Main {
	private static int n;
	private static int m;
	private static int[] arr;
	private static boolean[] num;
	private static int count = 0;
	private static boolean[] visited;
    private static boolean check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st ;
		
		
	   int c = 1;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
		
			
			if(n==0 && m==0) {
				break;
			}
			
			arr = new int[n+1];
			for(int i=1; i<=n; i++) {
		    	arr[i] = i;
		    }
			num = new boolean[n+1];
			visited = new boolean[n+1];
			check = true;
			
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int one = Integer.parseInt(st.nextToken());
				int two = Integer.parseInt(st.nextToken());
				union(one,two);
			}
			
			if(check) {
			    
				int[] countArr = new int[n+1];
				
			
				
				for(int i=1; i<arr.length; i++) {
					int find = find(arr[i]);
					countArr[find] ++;
				}
				
				for(int i=1; i<countArr.length; i++) {
					if(countArr[i] != 0 ) {
						count++;
					}
				}
				
			}else {
				int[] countArr = new int[n+1];
			
				
				for(int i=1; i<arr.length; i++) {
					int find = find(arr[i]);
					countArr[find]++;
				}
			
				for(int i=1; i<countArr.length; i++) {
					if(countArr[i] != 0 ) {
						if(!visited[i]) {
							count++;
						}
					
					}
				}	
				
			}
		
			
			if(count == 0) {
				System.out.println("Case " + c+":" + " No trees." );
			}else if(count == 1) {
				System.out.println("Case " + c+":" + " There is one tree.");
			
			}else {
				System.out.println("Case " + c + ":" + " A forest of " + count + " trees.");
			}
			
			c++;
			count = 0;
		}
		
		
		
	}
	
	private static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(visited[rootA] == true) {
			visited[rootB] = true;
		}
		if(visited[rootB] == true) {
			visited[rootA] = true;
		}
		
		if(rootA == rootB) {
			// 사이클이 돈다 
			// arr 초기화 
			visited[rootA] = true; 
			check = false;
		}
		
		
		if(rootA < rootB) {
			arr[rootB] = rootA;
		}else {
			arr[rootA] = rootB;
		}
	}
	
	private static int find(int a) {
		if(arr[a] == a) {
			return a;
		}
		return a = find(arr[a]);
		
	}
	
	private static void print() {
		for(int i=1; i<arr.length; i++) {
			System.out.print(arr[i]+ " ");
		}
		System.out.println();
	}

}