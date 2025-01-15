import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 절댓값 힙은 다음과 같은 연산을 지원하는 자료구조이다.
 * 배열에 정수 x (x ≠ 0)를 넣는다.
 * 배열에서 절댓값이 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다. 
 * 절댓값이 가장 작은 값이 여러개일 때는, 가장 작은 수를 출력하고, 그 값을 배열에서 제거한다.
 * 프로그램은 처음에 비어있는 배열에서 시작하게 된다.
 * 
 * 입력
 * 첫째 줄에 연산의 개수 N(1≤N≤100,000)이 주어진다.
 *  다음 N개의 줄에는 연산에 대한 정보를 나타내는 정수 x가 주어진다. 
 *  만약 x가 0이 아니라면 배열에 x라는 값을 넣는(추가하는) 연산이고, 
 *  x가 0이라면 배열에서 절댓값이 가장 작은 값을 출력하고 그 값을 배열에서 제거하는 경우이다.
 *   입력되는 정수는 -231보다 크고, 231보다 작다.
 *   만약 배열이 빈거면 출력한다 0을 
 *   
 *   우선 절대값이 큰순으로 정렬 되어있어야하고 
 *   그중에서 양수 음수 여야한다. 

 */

// 풀이
// 입력 n 을받고 
// x가 0이 아니라면 들어가고 x가 0 이라면 절대값이 가장 작은값 출력 그 값을 제거 해야한다
public class Main {
	
	static BufferedReader br;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pr = 우선순위큐생성();
	   
		답구하기(n,pr);
		
	}
	
	private static PriorityQueue<Integer> 우선순위큐생성() {
		PriorityQueue<Integer> pr = new PriorityQueue<Integer>((o1, o2) ->{
			if(Math.abs(o1) > Math.abs(o2)) {
				return Math.abs(o1) - Math.abs(o2);
			}else if(Math.abs(o1) == Math.abs(o2)) {
				return o1-o2;
			}else {
				return -1;
			}
		});
		
		return pr;
	}
	
	private static void 답구하기(int n, PriorityQueue<Integer> pr) throws IOException {
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num != 0) {
				pr.add(num);
			}else {
				if(!pr.isEmpty()) {
					System.out.println(pr.poll());
				}else {
					System.out.println(0);
				}
			}
			
			
			
		}
	}

}
