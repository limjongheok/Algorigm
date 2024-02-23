import java.io.*;
import java.util.*;

//
//NxN 크기의 복도가 있다. 
// 복도는 1x1 크기의 칸으로 나누어지며, 특정한 위치에는 선생님, 학생, 혹은 장애물이 위치할 수 있다. 
//현재 몇 명의 학생들은 수업시간에 몰래 복도로 빠져나왔는데, 복도로 빠져나온 학생들은 선생님의 감시에 들키지 않는 것이 목표이다.
//
//각 선생님들은 자신의 위치에서 상, 하, 좌, 우 4가지 방향으로 감시를 진행한다. 
//단, 복도에 장애물이 위치한 경우, 선생님은 장애물 뒤편에 숨어 있는 학생들은 볼 수 없다. 
//또한 선생님은 상, 하, 좌, 우 4가지 방향에 대하여, 아무리 멀리 있더라도 장애물로 막히기 전까지의 학생들은 모두 볼 수 있다고 가정하자.
//
//다음과 같이 3x3 크기의 복도의 정보가 주어진 상황을 확인해보자. 
//본 문제에서 위치 값을 나타낼 때는 (행,열)의 형태로 표현한다. 선
//생님이 존재하는 칸은 T, 학생이 존재하는 칸은 S, 장애물이 존재하는 칸은 O로 표시하였다.
//아래 그림과 같이 (3,1)의 위치에는 선생님이 존재하며 (1,1), (2,1), (3,3)의 위치에는 학생이 존재한다. 
//그리고 (1,2), (2,2), (3,2)의 위치에는 장애물이 존재한다. 
public class Main {
	private static int n;
	private static char[][] arr;
	private static char[][] copyArr;
	private static int[] dx = {-1,1};
	private static int[] dy = {-1,1};
	private static boolean check;
	private static int studentCount;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		n = Integer.parseInt(br.readLine());
		 
		 arr = new char[n][n];
		 
		 studentCount = 0;
		 for(int i=0; i<n; i++) {
			 st = new StringTokenizer(br.readLine());
			 for(int j=0; j<n; j++) {
				 arr[i][j] = st.nextToken().charAt(0);
				 if(arr[i][j] == 'S') {
					 studentCount ++;
				 }
			 }
			 
		 }
		 
		 check = false;
		 // 벽세우기 
		 dfs(0);
		 if(studentCount == 0) {
			 System.out.println("NO");
		 }else {
			 if(check) {
				 System.out.println("YES");
			 }else {
				 System.out.println("NO");
			 }
		 }
		 
		 
	}
	
	private static void dfs(int idx) {
		if(idx == 3) {
			
			// 각 선생들은 사방을 탐색하여 학생을 탐색해야한다. 
			int findStudent = 0;
			copyArr = new char[n][n];
			
			copy(); // arr copy 하기 
//			System.out.println("벽");
		//	print();
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(copyArr[i][j] == 'T') {
						findStudent(i, j);
					}
				}
			}
	
		
	
		    checkStudent(); // 학생 하나도 안지워지면 true
			
			return;
		}
		if(check) {
			return;
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(arr[i][j] == 'X') {
					arr[i][j] = 'O';
					dfs(idx +1);
					arr[i][j] = 'X';
				}
			}
		}
	}
	
	private static void copy() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				copyArr[i][j] = arr[i][j];
			}
		}
	}
	
	
	private static void checkStudent() {
		int count = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(copyArr[i][j] == 'S') {
					count ++;
				}
			}
		}
		if(count == studentCount) {
			check = true;
		
		}
	}
	private static void findStudent(int x, int y) {
		up(x,y); // 위 탐색
		down(x,y); // 아래 탐색
		left(x,y); // 왼 탐색
		right(x,y); // 우 탐색
		
	}
	private static void up(int x, int y) {
		if(copyArr[x][y] == 'O') { // 벽이면 멈추기
			return;
		}
		
		
		if(copyArr[x][y] == 'S') {
			// 학생이면 
			copyArr[x][y] = 'X';
		}
		
		int nextX = x + dx[0];
		
		if(nextX >=0 && nextX <n) {
			up(nextX, y);
		}
		
	}
	
	private static void down(int x, int y) {
		if(copyArr[x][y] == 'O') { // 벽이면 멈추기 
			return;
		}
		
		
		if(copyArr[x][y] == 'S') {
			// 학생이면 
			copyArr[x][y] = 'X';
		}
		
		int nextX = x + dx[1];
		
		if(nextX >=0 && nextX <n) {
			down(nextX, y);
		}
		
	}
	private static void left(int x, int y) {
		if(copyArr[x][y] == 'O') { // 벽이면 멈추기 
			return;
		}
		
		
		if(copyArr[x][y] == 'S') {
			// 학생이면 
			copyArr[x][y] = 'X';
		}
		int nextY = y + dy[0];
		if(nextY >=0 && nextY <n) {
			left(x, nextY);
		}
		
	}
	
	private static void right(int x, int y) {
		if(copyArr[x][y] == 'O') { // 벽이면 멈추기 
			return;
		}
		
	
		if(copyArr[x][y] == 'S') {
		// 학생이면 
			copyArr[x][y] = 'X';
		}
	
		int nextY = y + dy[1];
	
		if(nextY >=0 && nextY <n) {
			right(x,nextY);
		}
	
	}
	
	private static void print() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(copyArr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}