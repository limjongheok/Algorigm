import java.io.*;
import java.util.*;

public class Main {
	private static int n;
	private static int m;
	private static int[] arr;
	private static int result;
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
	    m = Integer.parseInt(st.nextToken());
		
		arr = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			arr[i] =i;
		}
		
		Node[] nodes = new Node[m];
		
		for(int i=0;  i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int one = Integer.parseInt(st.nextToken());
			int two = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			nodes[i] = new Node(one, two, cost); 
			
		}
		
		//1. 비용으로정렬
		Arrays.sort(nodes, (o1,o2) -> Integer.compare(o1.cost, o2.cost));
		result = 0;
		for(int i=0; i<m; i++) {
			Node node = nodes[i];
			int one =node.one;
			int two = node.two;
			int cost = node.cost;
			union(one,two,cost);
		}
		System.out.println(result);
	}
	
	private static void union(int one, int two, int cost) {
		int findOne = find(one);
		int findTwo = find(two);
		
		if(findOne == findTwo) {
			return;
		}
		
		if(findOne != findTwo) {
			
			arr[findOne] = findTwo;
			result += cost;
		}
	}
	
	private static int find(int num) {
		if(num == arr[num]) {
			return num;
		}
		return arr[num] = find(arr[num]);
	}
	
	private static class Node{
		int one;
		int two;
		int cost;
		
		public Node(int one, int two, int cost) {
			this.one = one;
			this.two = two;
			this.cost =cost;
		}
	}

}
