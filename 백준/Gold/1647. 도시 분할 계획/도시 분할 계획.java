import java.io.*;
import java.util.*;
public class Main {
	private static int[] arr;
	private static int costSum;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		 arr = new int[n+1];
		for(int i=1; i<=n; i++) {
			arr[i] = i;
		}
		
		Node[] nodes = new Node[m];
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			nodes[i] = new Node(a,b,cost);
			
		}
		
		Arrays.sort(nodes,(o1,o2) -> Integer.compare(o1.cost, o2.cost)); // cost로 정렬 
		
		costSum = 0;
		int bigCost = 0;
		int[] countArr = new int[arr.length];
		for(int i=0; i<m; i++) {
			
			Node node = nodes[i];
			
			if(find(node.x) != find(node.y)) { // 사이클이 돌지 않으면
				costSum+= node.cost;
				union(node.x,node.y, node.cost);
				
				bigCost = node.cost;
			}
		
		}                                                                                                                                                                                                                                                                                                                                                                  
		
		
		System.out.println(costSum - bigCost);
		
	}
	
	private static void union(int x, int y, int cost) {
		
	
		
		int findX = find(x);
		int findY = find(y);
	
		
		if(findX != findY) {
			arr[findX] = findY;
		}
		
		
	}
	
	private static int find(int num) {
		if(arr[num] == num) {
			return num;
		}
		
		return arr[num] = find(arr[num]);
	}
	private static class Node{
		int x;
		int y;
		int cost;
		
		public Node(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
	}

}
