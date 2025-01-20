import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 아래 <그림 1>과 같이 정사각형 칸들로 이루어진 사각형 모양의 판이 있고, 그 위에 얇은 치즈(회색으로 표시된 부분)가 놓여 있다.
 *  판의 가장자리(<그림 1>에서 네모 칸에 X친 부분)에는 치즈가 놓여 있지 않으며 치즈에는 하나 이상의 구멍이 있을 수 있다.
 *  이 치즈를 공기 중에 놓으면 녹게 되는데 공기와 접촉된 칸은 한 시간이 지나면 녹아 없어진다.
 *   치즈의 구멍 속에는 공기가 없지만 구멍을 둘러싼 치즈가 녹아서 구멍이 열리면 구멍 속으로 공기가 들어가게 된다. 
 *   <그림 1>의 경우, 치즈의 구멍을 둘러싼 치즈는 녹지 않고 ‘c’로 표시된 부분만 한 시간 후에 녹아 없어져서 <그림 2>와 같이 된다.
 *   
 *   <그림 1> 원래 치즈 모양
 *   다시 한 시간 후에는 <그림 2>에서 ‘c’로 표시된 부분이 녹아 없어져서 <그림 3>과 같이 된다.
 *   <그림 2> 한 시간 후의 치즈 모양
 *   <그림 3> 두 시간 후의 치즈 모양
 *   <그림 3>은 원래 치즈의 두 시간 후 모양을 나타내고 있으며, 남은 조각들은 한 시간이 더 지나면 모두 녹아 없어진다
 *    그러므로 처음 치즈가 모두 녹아 없어지는 데는 세 시간이 걸린다. <그림 3>과 같이 치즈가 녹는 과정에서 여러 조각으로 나누어 질 수도 있다.
 *    입력으로 사각형 모양의 판의 크기와 한 조각의 치즈가 판 위에 주어졌을 때, 
 *    공기 중에서 치즈가 모두 녹아 없어지는 데 걸리는 시간과 모두 녹기 한 시간 전에 남아있는 치즈조각이 놓여 있는 칸의 개수를 구하는 프로그램을 작성하시오.
 * 
 * 입력
 * 
 * 첫째 줄에는 사각형 모양 판의 세로와 가로의 길이가 양의 정수로 주어진다.
 *  세로와 가로의 길이는 최대 100이다. 판의 각 가로줄의 모양이 윗 줄부터 차례로 둘째 줄부터 마지막 줄까지 주어진다.
 *  치즈가 없는 칸은 0, 치즈가 있는 칸은 1로 주어지며 각 숫자 사이에는 빈칸이 하나씩 있다.
 */

// 풀이 
// 입력 n m 을 받는다 n은 세로 m 은 가로 
// 치즈판만들기()
// 치즈찾아녹이기()

// ----- 치즈판만들기
// n과 m을 이용하여 치즈판을 만든다. 


// --- 치즈 찾아 녹이기 
// 치즈가 없을때 까지 반복한다. 
// 배열 = 녹일치즈찾기()
// 치즈 녹이기(배열)
// 시간 증가하기++
// 치즈찾기 

// 만약 없으면 반복을 빠져나온다

//---- 녹일 치즈 찾기
// 0,0 부터 시작해서 0이면 큐에 담고 bfs 탐색을 진행한다 
// 만약 1을 만나면 새로운 배열에 담는다 
// 새로운 배열을 리턴한다. // 즉 녹일 치즈 큐 


// ----- 치즈 녹이기 
// 현재 치즈 판에서 배열에 있는것들을 녹인다 즉 0으로 변경한다.

// ----- 치즈 찾기
// 현재 치즈판에서 치즈가 있는지 없는지 찾는다. 
public class Main {
	
	static BufferedReader br;
	static StringTokenizer st;
	
	static int n;
	static int m;
	static int time = 0;
	static int 마지막치즈개수 = 0;
	
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		int[][] 치즈판 = 치즈판만들기();

		치즈찾아녹이기(치즈판);
		
		System.out.println(time);
		System.out.println(마지막치즈개수);
	}
	
	
	// ----- 치즈판만들기
	// n과 m을 이용하여 치즈판을 만든다.
	
	private static int[][] 치즈판만들기() throws IOException {
		int[][] 치즈판 = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				int num = Integer.parseInt(st.nextToken());
				치즈판[i][j] = num;
				if(num ==1) {
					마지막치즈개수++;
				}
			}
		}
		
		return 치즈판;
	}
	
	// --- 치즈 찾아 녹이기 
	// 치즈가 없을때 까지 반복한다. 
	// 배열 = 녹일치즈찾기()
	// 치즈 녹이기(배열)
	// 시간 증가하기++
	// 치즈찾기 
	
	private static void 치즈찾아녹이기(int[][] 치즈판) {
		
		while(true) {
			Queue<Node> 녹일치즈 = 녹일치즈찾기(치즈판);
			치즈녹이기(녹일치즈, 치즈판);
			time ++;
			boolean state = 치즈찾기(치즈판);
			if(state) {
				break;
			}
		}
	}
	
	//---- 녹일 치즈 찾기
	// 0,0 부터 시작해서 0이면 큐에 담고 
	// bfs 탐색을 진행한다 현재 나온 좌표 0이겠지 상하좌우 이동하며
	// 방문 하지 않고 다음 좌표가 0 이면 방문시키고 큐에 넣기 
	// 만약 1을 만나면 새로운 배열에 담는다 
	// 새로운 배열을 리턴한다. // 즉 녹일 치즈 큐 
	
	private static Queue<Node> 녹일치즈찾기(int[][] 치즈판) {
		
		boolean[][] visited = new boolean[n][m];
		visited[0][0] = true;
		
		Queue<Node> queue = new LinkedList();
		Queue<Node> 녹일치즈 = new LinkedList();
		queue.add(new Node(0,0));
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			int nowX = node.x;
			int nowY = node.y;
			
			for(int i=0; i<4; i++) {
				int nextX = dx[i] + nowX;
				int nextY = dy[i] + nowY;
				
				if(nextX <0 || nextX >=n || nextY <0 || nextY >=m || visited[nextX][nextY]) {
					continue;
				}
				
				if(치즈판[nextX][nextY] == 0) {
					visited[nextX][nextY] = true;
					queue.add(new Node(nextX, nextY));
				}
				
				if(치즈판[nextX][nextY] == 1) {
					visited[nextX][nextY] = true;
					녹일치즈.add(new Node(nextX, nextY));
				}
			}
		}
		
		return 녹일치즈;
		
	}
	
	private static void 치즈녹이기(Queue<Node> 녹일치즈, int[][] 치즈판 ) {
		
		while(!녹일치즈.isEmpty()) {
			Node 치즈 = 녹일치즈.poll();
			치즈판[치즈.x][치즈.y] = 0;
		}
	}
	
	private static boolean 치즈찾기(int[][] 치즈판) {
		
		boolean state = false;
		
		int 찾은치즈 = 0;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(치즈판[i][j] ==1) {
					찾은치즈++;
				}
			}
		}
		
	    if(찾은치즈 == 0) { // 모든치즈 다 녹임
	    	state = true;
	    }else {
	    	마지막치즈개수 = 찾은치즈;
	    }
		
		return state;
	}

}

class Node{
	int x;
	int y;
	
	public Node (int x, int y) {
		this.x = x ;
		this.y = y;
	}
}