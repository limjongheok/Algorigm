import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
	private static Map<Integer,Integer> map;
	private static int n;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
	
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());// 종이컵 수 
			int x = Integer.parseInt(st.nextToken()); // 왼쪽 몇 번 째
			int k = Integer.parseInt(st.nextToken()); // 위치 바꾸는 횟수
			map = new HashMap();
			for(int i=0; i<n; i++) {
				map.put(i+1, i+1);
			}
			
			for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
				int one = Integer.parseInt(st.nextToken());
				int two = Integer.parseInt(st.nextToken());
				
				swap(one,two);
				
				
				
			}
			for(int i: map.keySet()) {
				if(map.get(i) == x) {
					System.out.println(i);
					break;
				}
			}
		
     	
		
		
	}
	private static void swap(int one, int two) {
		int tmp = map.get(one);
		int tmp2 = map.get(two);
	
		map.put(one, tmp2);
		map.put(two, tmp);
	}
	
}