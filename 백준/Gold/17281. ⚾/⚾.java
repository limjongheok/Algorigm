import java.io.IOException;
import java.io.* ;
import java.util.*;

//⚾는 9명으로 이루어진 두 팀이 공격과 수비를 번갈아 하는 게임이다.
//하나의 이닝은 공격과 수비로 이루어져 있고,
//총 N이닝 동안 게임을 진행해야 한다. 
//한 이닝에 3아웃이 발생하면 이닝이 종료되고,
//두 팀이 공격과 수비를 서로 바꾼다.

//두 팀은 경기가 시작하기 전까지 타순(타자가 타석에 서는 순서)을 정해야 하고, 
//경기 중에는 타순을 변경할 수 없다.
//9번 타자까지 공을 쳤는데 3아웃이 발생하지 않은 상태면 이닝은 끝나지 않고, 
//1번 타자가 다시 타석에 선다. 타순은 이닝이 변경되어도 순서를 유지해야 한다. 
//예를 들어, 2이닝에 6번 타자가 마지막 타자였다면, 
//3이닝은 7번 타자부터 타석에 선다.

//공격은 투수가 던진 공을 타석에 있는 타자가 치는 것이다.
//공격 팀의 선수가 1루, 2루, 3루를 거쳐서 홈에 도착하면 1점을 득점한다. 
//타자가 홈에 도착하지 못하고 1루, 2루, 3루 중 하나에 머물러있을 수 있다.
//루에 있는 선수를 주자라고 한다. 
//이닝이 시작될 때는 주자는 없다.

//타자가 공을 쳐서 얻을 수 있는 결과는 안타, 2루타, 3루타, 홈런, 아웃 중 하나이다.
//각각이 발생했을 때, 벌어지는 일은 다음과 같다.

//안타: 타자와 모든 주자가 한 루씩 진루한다.
//2루타: 타자와 모든 주자가 두 루씩 진루한다.
//3루타: 타자와 모든 주자가 세 루씩 진루한다.
//홈런: 타자와 모든 주자가 홈까지 진루한다.
//아웃: 모든 주자는 진루하지 못하고, 공격 팀에 아웃이 하나 증가한다.
//한 야구팀의 감독 아인타는 타순을 정하려고 한다.
//아인타 팀의 선수는 총 9명이 있고, 
//1번부터 9번까지 번호가 매겨져 있다.
//아인타는 자신이 가장 좋아하는 선수인 1번 선수를 4번 타자로 미리 결정했다.
//이제 다른 선수의 타순을 모두 결정해야 한다. 
//아인타는 각 선수가 각 이닝에서 어떤 결과를 얻는지 미리 알고 있다.
//가장 많은 득점을 하는 타순을 찾고,
//그 때의 득점을 구해보자.
public class Main {
	private static boolean visited[];
	private static int[] member;
	private static int n;
	private static StringTokenizer st;
	private static BufferedReader br;
	private static int playNum; // 타자 번호
	private static int[][] arr;
	private static int max;
	
	public static void main(String[] args) throws IOException{
		 br = new BufferedReader(new InputStreamReader(System.in));
	
		
		 n = Integer.parseInt(br.readLine()); // 이닝 수 
		 arr = new int[n][10]; // 이닝시 타 
		 
		 for(int i=0; i<n; i++) {
			 batting(i);
		 }
		
		
		 
	    member  = new int[9];
		visited = new boolean[10];	
		
		member[3] = 1; 
		visited[1] = true;
		// 타자 지정 순열 
		max = Integer.MIN_VALUE;
		
		dfs(0);
		System.out.println(max);
	}
	
	private static void dfs(int idx) throws IOException {
		if(idx == 9) {
			// 야구 하기 
			playNum = 0; // 타자 번호 0번 
			int result = 0;
			for(int i=0; i<n; i++) {
				result += play(i); // 게임 실행 // totalCount++
				
			}
			
			max = Math.max(max, result);
		
			return;
		}
		

		for(int i=2; i<=9; i++) {
		
			if(!visited[i]) {
				visited[i] = true;
				if(idx == 3) {
					idx++;
				}
				member[idx] = i;
				dfs(idx+1);
				visited[i] = false;
			}
		}
		return;
	}
	
	private static void	batting(int idx) throws IOException { // 이닝
		 st = new StringTokenizer(br.readLine());
	
	
		 
		 for(int i=1; i<10; i++) {
			 arr[idx][i] = Integer.parseInt(st.nextToken());
		 }
		 
		 	 
	}
	private static int play(int idx) {
		int outCount = 0;
		
		
		boolean[] isInBase = new boolean[4];
		

		int count = 0;
	
		
		
		while(outCount <3) {
		
			// 현재 타자 
			//[4, "조합"]
			int nowPlayer = member[playNum];
			//System.out.println(nowPlayer);
			// 현재 타자 타
			int hit = arr[idx][nowPlayer];
			
			
			if(hit == 0) {
				outCount++;
			}
			if(hit == 1) {
				if(isInBase[3]) count++;	//3루 true라면 점수 +1
				
				//출루 선수 이동
				isInBase[3] = isInBase[2];	//2->3
				isInBase[2] = isInBase[1];	//1->2
				
				//타자 이동
				isInBase[1] = true;			//타자 -> 1루
	
				
			}
			if(hit == 2) {
				if(isInBase[3]) count++;	//3루 true라면 점수 +1
			if(isInBase[2]) count++;	//2루 true라면 점수 +1
			
			//출루 선수 이동
			isInBase[3] = isInBase[1];	//1->3 이동
			isInBase[1] = false;		//1루 비우기
			
			//타자 이동
			isInBase[2] = true;			//타자 -> 2루

				
			}
			if(hit ==3) {
				if(isInBase[3]) count++;	//3루 true라면 점수 +1
				if(isInBase[2]) count++;	//2루 true라면 점수 +1
				if(isInBase[1]) count++;	//1루 true라면 점수 +1
				
				//출루 선수 이동
				isInBase[2] = false;		//2루 비우기
				isInBase[1] = false;		//1루 비우기
				
				//타자 이동
				isInBase[3] = true;			//타자 -> 3루

			}
			if(hit == 4) {
				// 홈런 
				if(isInBase[3]) count++;	//3루 true라면 점수 +1
				if(isInBase[2]) count++;	//2루 true라면 점수 +1
				if(isInBase[1]) count++;	//1루 true라면 점수 +1
				count++;					//타자 점수 cnt
				
				//출루 선수 이동
				for(int i=1; i<=3; i++) isInBase[i] = false;	//1,2,3루 비우기

				
			}
	
			// 다하고 playNum 증가 만약 playNum 이 9가 되면 0으로 
			
			playNum++;
			if(playNum == 9) {
				playNum = 0;
			}
			
		}
		
		
		return count;
	}
	
	private static void print() {
		for(int i=0; i<9; i++) {
			System.out.print(member[i] +" ");
		}
		System.out.println();
	}
	
	private static void basePrint(int[] base) {
		for(int i=0; i<base.length; i++) {
			System.out.print(base[i] + " ");
		}
		System.out.println();
	}

}
