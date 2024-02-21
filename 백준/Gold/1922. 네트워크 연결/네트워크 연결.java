
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int[] arr;
	private static int costSum;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		Node[] nodes= new Node[m];
		

		arr = new int[n+1];
		for(int i=1; i<=n; i++) {
			arr[i] = i; 
		}

		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			Node node = new Node(a,b,cost);
			nodes[i] = node;
			
		}
		
		Arrays.sort(nodes, (o1,o2) -> Integer.compare(o1.cost, o2.cost));
		
		
		costSum = 0;
	    for(int i=0; i<nodes.length; i++) {
	    	Node arrNode = nodes[i];
	    	union(arrNode.a, arrNode.b, arrNode.cost);
	    	
	    }
	    System.out.println(costSum);
	}
	
	
	private static void union(int one , int two, int cost) {
		int findOne = find(one);
		int findTwo = find(two);
		
		if(findOne == findTwo) { 
			// 사이클이 돌아
			return ;
			
		}
		
		if(findOne > findTwo) {
			arr[findOne] = findTwo;
			costSum += cost;
		}else {
			arr[findTwo] = findOne;
			costSum += cost;
		}
		
		
	}
	
	private static int find(int num) {
		
		
		if(arr[num] == num) {
			return num;
		}
		
		return num = find(arr[num]);
		
	}
	private static void print() {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static class Node{
		int a;
		int b;
		int cost;
		
		
		public Node(int a, int b, int cost) {
			this.a = a;
			this.b = b;
			this.cost = cost;
		}


		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return a + " a" + b + "b" +cost + "cost";
		}
		
		
	}

}
