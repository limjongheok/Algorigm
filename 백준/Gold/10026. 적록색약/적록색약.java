import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 적록색약은 빨간색과 초록색의 차이를 거의 느끼지 못한다. 따라서, 적록색약인 사람이 보는 그림은 아닌 사람이 보는 그림과는 좀 다를 수 있다.
 * 크기가 N×N인 그리드의 각 칸에 R(빨강), G(초록), B(파랑) 중 하나를 색칠한 그림이 있다.
 *  그림은 몇 개의 구역으로 나뉘어져 있는데, 구역은 같은 색으로 이루어져 있다. 
 *  또, 같은 색상이 상하좌우로 인접해 있는 경우에 두 글자는 같은 구역에 속한다. (색상의 차이를 거의 느끼지 못하는 경우도 같은 색상이라 한다)
 *  예를 들어, 그림이 아래와 같은 경우에
 *  RRRBB
 *  GGBBB
 *  BBBRR
 *  BBRRR
 *  RRRRR
 *  
 *  적록색약이 아닌 사람이 봤을 때 구역의 수는 총 4개이다. (빨강 2, 파랑 1, 초록 1) 
 *  하지만, 적록색약인 사람은 구역을 3개 볼 수 있다. (빨강-초록 2, 파랑 1)
 *  그림이 입력으로 주어졌을 때, 적록색약인 사람이 봤을 때와 아닌 사람이 봤을 때 구역의 수를 구하는 프로그램을 작성하시오.
 *  
 *  입력
 *  첫째 줄에 N이 주어진다. (1 ≤ N ≤ 100)
 *  둘째 줄부터 N개 줄에는 그림이 주어진다.
 */


// 문제 풀이 
// n을 입력을 받는다 
// 적록색략, 적록색략이 아닌사람의 판을 만들기 
// 적록 색략 탐색

//----- 적록색략 아닌 사람의 판 만들기 
// n 개 만큼의 세로 가로 입력을 받아 만들기 

//----- 적록 색략인 사람 판 만들기 
// n 개만큼 세로 가로에 R을 입력 받음 G로 변환하여 만들기 

//---- 색략 탐색 (적록 색략 or 적록 아닌 색략) 
// for n n 을 돌면서 
// 방문이 안되어 있으면 방문시키고 
// count를 1 증가 시키고 
//bfs 탐색을 한다 bfs 탐색을 하며 자신가 같은 색이면 방문 시킨다. -- 이때 같은색이면 방문을 하기 때문 다음 for문은 방문 안된 다른 인접 색이라는 뜻 

//--- bfs 탐색
// 현재 노드를 꺼내고 해당 노드와 같은 색인 다음 노드이면 방문 안하면 방문시키기
public class Main {
	
	static BufferedReader br;
	
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	static int N;
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		char[][] 적록아닌색략판 = 적록아닌색략판만들기();
		char[][] 적록색략판 = 적록색략판만들기(적록아닌색략판);
		
		int 적록아닌색략count = 적록탐색(적록아닌색략판);
		int 적록색략count = 적록탐색(적록색략판);
		
		System.out.println(적록아닌색략count + " " +  적록색략count);
		
	}
	
	private static char[][] 적록아닌색략판만들기() throws IOException {
		char[][] 적록아닌색략판 = new char[N][N];
		
		for(int i=0; i<N; i++) {
			String 색들 = br.readLine();
			for(int j=0; j<N; j++) {
				적록아닌색략판[i][j] = 색들.charAt(j);
			}
		}
		
		return 적록아닌색략판;
	}

	private static char[][] 적록색략판만들기(char[][] 적록아닌색략판) throws IOException {
		char[][] 적록색략판 = new char[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(적록아닌색략판[i][j] == 'R') {
					적록색략판[i][j] = 'G';
				}else {
					적록색략판[i][j] = 적록아닌색략판[i][j];
				}

			}
		}
		
		return 적록색략판;
	}
	
	private static int 적록탐색(char[][] 색록판) {
		
		int count = 0;
		
		boolean[][] visited = new boolean[N][N]; // 방문지점
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(visited[i][j]) {
					continue;
				}
				
				visited[i][j] = true;
				count++;
				bfs(색록판, visited, new Node(i,j), 색록판[i][j]);
			}
		}
		
		return count;
	}
	
	private static void bfs(char[][] 색록판, boolean[][] visited, Node node, char 색) {
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(node);
		
		while(!queue.isEmpty()) {
			Node nowNode = queue.poll();
			int nowX = nowNode.x;
			int nowY = nowNode.y;
			
			for(int i=0; i<4; i++) {
				int nx = nowNode.x + dx[i];
				int ny = nowNode.y + dy[i];
				
				// 넘고, 방문지점들렸고, 다음색이 현재 색이랑 다를때 
				if(nx <0 || nx >= N || ny <0 || ny >=N || visited[nx][ny] || 색 != 색록판[nx][ny]) {
					continue;
				}
				
				visited[nx][ny] = true;
				queue.add(new Node(nx,ny));
			}
		}
	}
}

class Node {
	int x;
	int y;
	
	public Node(int x, int y){
		this.x = x;
		this.y = y;
	}
}
