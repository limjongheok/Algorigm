import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 인체에 치명적인 바이러스를 연구하던 연구소에서 바이러스가 유출되었다. 다행히 바이러스는 아직 퍼지지 않았고, 바이러스의 확산을 막기 위해서 연구소에 벽을 세우려고 한다.

연구소는 크기가 N×M인 직사각형으로 나타낼 수 있으며, 직사각형은 1×1 크기의 정사각형으로 나누어져 있다. 연구소는 빈 칸, 벽으로 이루어져 있으며, 벽은 칸 하나를 가득 차지한다. 

일부 칸은 바이러스가 존재하며, 이 바이러스는 상하좌우로 인접한 빈 칸으로 모두 퍼져나갈 수 있다. 새로 세울 수 있는 벽의 개수는 3개이며, 꼭 3개를 세워야 한다.

예를 들어, 아래와 같이 연구소가 생긴 경우를 살펴보자.

2 0 0 0 1 1 0
0 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 0 0
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0
이때, 0은 빈 칸, 1은 벽, 2는 바이러스가 있는 곳이다. 아무런 벽을 세우지 않는다면, 바이러스는 모든 빈 칸으로 퍼져나갈 수 있다.

2행 1열, 1행 2열, 4행 6열에 벽을 세운다면 지도의 모양은 아래와 같아지게 된다.

2 1 0 0 1 1 0
1 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 1 0
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0
바이러스가 퍼진 뒤의 모습은 아래와 같아진다.

2 1 0 0 1 1 2
1 0 1 0 1 2 2
0 1 1 0 1 2 2
0 1 0 0 0 1 2
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0
벽을 3개 세운 뒤, 바이러스가 퍼질 수 없는 곳을 안전 영역이라고 한다. 위의 지도에서 안전 영역의 크기는 27이다.

연구소의 지도가 주어졌을 때 얻을 수 있는 안전 영역 크기의 최댓값을 구하는 프로그램을 작성하시오.

입력

첫째 줄에 지도의 세로 크기 N과 가로 크기 M이 주어진다. (3 ≤ N, M ≤ 8)

둘째 줄부터 N개의 줄에 지도의 모양이 주어진다. 0은 빈 칸, 1은 벽, 2는 바이러스가 있는 위치이다. 2의 개수는 2보다 크거나 같고, 10보다 작거나 같은 자연수이다.

빈 칸의 개수는 3개 이상이다.
 */

// 풀이 

// 입력 n 과 m을 받는다 n 세로 m 가로 
// 맵만들기()
// 안전지대를 출력한다. 

//---- 맵만들기 
// n m 을 통해 맵을 만든다
// 0 빈벽을 list에 담는다 
// 공유 영역으로 안전지대 만든다 안전지역은 integer.minvalue


// --- 맵에서 3개 빈벽을 뽑기 
// count 가 3 이 될때 까지 3개의 조합을 뽑느다 
// count 3일때 멈춤 
// count 3 일때 바이러스 감염시키기


// for(int i =시작지점; i<visite.length까지 돌때)
// 방문하지 않으면
// visited[i] = true
// 해당 지역 벽 칠하기 
// 빈벽뽑기(count+1, visited, i, map)
// visited[i] = false 하기  
// 해당지역 벽 해제하기 

// ------- 바이러스 감염시키기
// for 문으로 2 탐색 해서 queue 에 담기 
// visited 해당 지역 방문하기
// bfs(queue, visited, map)
// 안전 지역 탐색

//----- bfs(queue, visited, map)
// queue 가 빌때까지 
// 방문하지 않고 다음노드가 0 이 아니고 map 범위 밖이면 continue
// 방문하고 큐 넣기 

//--- 안전지역 탐색 
// count
// for n m 을 돌며 0 읓 찾아 count를 올린다 
// count가 안전지대 보다 크면 안전지대는 count 가 된다 
public class Main {
	
	static BufferedReader br;
	static StringTokenizer st;
	
	static List<Node> list;
	
	static int N;
	static int M;
	static int 안전영역최대크기 = Integer.MIN_VALUE;
	
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList<Node>();
		
		int[][] map = 맵만들기();
		
		boolean[] visited = new boolean[list.size()];
		빈벽뽑기(0,0,visited,map);
		
		System.out.println(안전영역최대크기);
		
	}
	
	//---- 맵만들기 
	// n m 을 통해 맵을 만든다
	// 0 빈벽을 list에 담는다 
	// 공유 영역으로 안전지대 만든다 안전지역은 integer.minvalue

	private static int[][] 맵만들기() throws IOException {
		int[][] map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				int num = Integer.parseInt(st.nextToken());
				
				if(num==0) { // 빈벽 저장
					list.add(new Node(i, j));
				}
				
				
				map[i][j] = num;
			}
		}
		
		return map;
	}
	
	
	// --- 맵에서 3개 빈벽을 뽑기 
	// count 가 3 이 될때 까지 3개의 조합을 뽑느다 
	// count 3일때 멈춤 
	// count 3 일때 바이러스 감염시키기


	// for(int i =시작지점; i<visite.length까지 돌때)
	// 방문하지 않으면
	// visited[i] = true
	// 해당 지역 벽 칠하기 
	// 빈벽뽑기(count+1, visited, i, map)
	// visited[i] = false 하기  
	// 해당지역 벽 해제하기 
	
	private static void 빈벽뽑기(int count, int 시작지점 , boolean[] visited , int[][] map) {
		
		// 빈벽이 3개일시 
		if(count == 3) {
			
			int[][] copyMap = 맵카피하기(map);
			바이러스감염(copyMap);
			
			return;
		}
		
		for(int i=시작지점; i<visited.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				Node node = list.get(i);
				map[node.x][node.y] = 1;
				빈벽뽑기(count+1, i+1, visited, map);
				visited[i] = false;
				map[node.x][node.y] = 0;
			}
		}
		
	}
	
	private static int[][] 맵카피하기(int[][] map) {
		int[][] copyMap = new int[N][M];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
		
		return copyMap;
	}
	
	// ------- 바이러스 감염시키기
	// for 문으로 2 탐색 해서 queue 에 담기 
	// visited 해당 지역 방문하기
	// bfs(queue, visited, map)
	// 안전 지역 탐색
	
	private static void 바이러스감염(int[][] map) {
		
		Queue<Node> queue = new LinkedList<Node>();
		boolean[][] visited = new boolean[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] ==2) { // 감염 노드이면
					queue.add(new Node(i,j));
					visited[i][j] = true;
					
					bfs(queue, visited, map);// 인접노드 감염시키기
				}
			}
		}
		안전지대탐색(map);
	}
	
	
	//----- bfs(queue, visited, map)
	// queue 가 빌때까지 
	// 방문하지 않고 다음노드가 0 이 아니고 map 범위 밖이면 continue
	// 방문하고 map[][]다음노드 2로 변경하고 큐 넣기 

	private static void bfs(Queue<Node> queue, boolean[][] visited, int[][] map) {
		
		while(!queue.isEmpty()) {
			Node nowNode = queue.poll();
			int nowX = nowNode.x;
			int nowY = nowNode.y;
			
			for(int i=0; i<4; i++) {
				int nx = nowX +dx[i];
				int ny = nowY + dy[i];
				
				// 다음 좌표가 map 범위 벗어나고, 0이 아니고 방문 했으면 continue;
				if(nx <0 || nx >=N || ny <0 || ny >=M || visited[nx][ny] || map[nx][ny] !=0 ) {
					continue;
				}
				
				visited[nx][ny] = true;
				map[nx][ny] = 2;
				
				queue.add(new Node(nx,ny));
			}	
		}
	}
	
	
	//--- 안전지역 탐색 
	// count
	// for n m 을 돌며 0 읓 찾아 count를 올린다 
	// count가 안전지대 보다 크면 안전지대는 count 가 된다 
	private static void 안전지대탐색(int[][] map) {
		
		int count = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++)
				if(map[i][j] == 0) {
					count++;
				}
		}
		
		if(안전영역최대크기 < count) {
			안전영역최대크기 = count;
		}
	}

}

class Node{
	int x;
	int y;
	
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
