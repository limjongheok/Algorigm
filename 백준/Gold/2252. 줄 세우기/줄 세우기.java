import java.io.*;
import java.util.*;
public class Main {
	private static int[] arr;
	private static List<Integer>[] map;
	private static int one;
	private static int two;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		arr = new int[n+1];
		map = new ArrayList[n+1];
		 for(int i=1; i<=n; i++){
	            map[i] = new ArrayList<Integer>();
	        }

		for(int i=0; i<m; i++) {
			st =new StringTokenizer(br.readLine());
			one = Integer.parseInt(st.nextToken());
			two = Integer.parseInt(st.nextToken());
			arr[two] ++;
			map[one].add(two);
		}
		
		Queue<Integer> queue = new LinkedList();
		
		for(int i=1; i<arr.length; i++) {
			if(arr[i] == 0) {
				queue.add(i);
			
			}
		}
		
		while(!queue.isEmpty()) {
			
			
			int nx = queue.poll();
			
			System.out.print(nx + " ");
		
			for(int i=0; i<map[nx].size(); i++) {
				int next = map[nx].get(i);
				arr[next]--;
				if(arr[next] == 0) {
					queue.add(next);
				}
			}
			
			
			
		}
		
		
		
	}

}