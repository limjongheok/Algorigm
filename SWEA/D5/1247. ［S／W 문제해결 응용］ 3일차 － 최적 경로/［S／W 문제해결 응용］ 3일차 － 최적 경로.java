/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.*;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	private static boolean[] visited;
	private static int n;
	private static int startX; // 이전 xy
	private static int startY;
	private static Nodes sumStart;
	private static Nodes startSum;
	private static Nodes sumEnd;
	private static int min;
	private static int endX;
	private static int endY;
	private static Nodes[] sums;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for(int t=1 ; t<=tc; t++) {
		 n= Integer.parseInt(br.readLine());
			
			visited = new boolean[n];
			
			st = new StringTokenizer(br.readLine());
			 startX = Integer.parseInt(st.nextToken());
			 startY  = Integer.parseInt(st.nextToken());
			 sumStart = new Nodes(startX,startY);
			 startSum = sumStart;
			 endX = Integer.parseInt(st.nextToken());
			 endY = Integer.parseInt(st.nextToken());
			 sumEnd = new Nodes(endX,endY);
	
			sums = new Nodes[n];
			
			for(int i=0; i<n; i++) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				Nodes node = new Nodes(x,y);
				sums[i] =node;
			}
			min = Integer.MAX_VALUE;
			Nodes[] arr2 = new Nodes[n];
			dfs(0,arr2);
			System.out.println("#"+t+" "+min);
			
			
			
			
		}
		
	}
	private static void dfs(int idx, Nodes[] arr2) { // 순열
	
		sumStart = startSum;
		if(idx == n) {
			

			
		
			List<Integer> list = new ArrayList();
			for(Nodes i: arr2) {
				list.add(resultSum(i));
			}
			list.add(resultSum(sumEnd));
		
			
			int reSum = 0;
			for(int i: list) {
				reSum +=i;
			}
		
			min = Math.min(reSum, min);
			
			
			return ; // 종료
		}
		
		for(int i=0; i<n; i++) {
			if(!visited[i]) {
				visited[i] = true;
			    arr2[idx] = sums[i];
			    dfs(idx+1,arr2);
			    visited[i] = false;
			}
		}
	}
	
	private static int resultSum (Nodes node) {
	    int result = Math.abs(sumStart.x-node.x) + Math.abs(sumStart.y-node.y);
	   
	    sumStart = node;
	    return result;
	}
	

}

class Nodes{
	int x;
	int y;
	public Nodes(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	
}

