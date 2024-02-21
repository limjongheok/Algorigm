import java.io.*;
import java.util.*;

import java.io.*;
import java.util.*;

public class Main {
	private static List<Integer>[] arr;
	private static int m;
	private static boolean check;
	private static boolean[] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		 m = Integer.parseInt(st.nextToken());
		arr = new List[n];
		for(int i=0; i<n; i++) {
			arr[i] = new ArrayList();
		}
	
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int one = Integer.parseInt(st.nextToken());
			int two = Integer.parseInt(st.nextToken());
			
			arr[one].add(two); // 연결 리스트 생성 
			arr[two].add(one);
		}
		
		 check = false;

		for(int i=0; i<n; i++) {
			visited = new boolean[n];
			visited[i] = true;
			dfs(i,1);
			if(check) {
				break;
			}
			
		}
		if(check) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
		
	}
	
	private static void dfs(int idx, int count) {
		
		if(count == 5) {
			check = true;
			return ;
		}
		
		for(int i=0; i<arr[idx].size(); i++) {
			if(!visited[arr[idx].get(i)]) {
				visited[arr[idx].get(i)] = true;
				dfs(arr[idx].get(i),count+1);
				visited[arr[idx].get(i)] = false;
			}
		
		}
	}
	
	
}

