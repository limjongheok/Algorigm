import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
 * ⚾는 9명으로 이루어진 두 팀이 공격과 수비를 번갈아 하는 게임이다. 
 * 하나의 이닝은 공격과 수비로 이루어져 있고, 총 N이닝 동안 게임을 진행해야 한다. 
 * 한 이닝에 3아웃이 발생하면 이닝이 종료되고, 두 팀이 공격과 수비를 서로 바꾼다.
 * 두 팀은 경기가 시작하기 전까지 타순(타자가 타석에 서는 순서)을 정해야 하고, 경기 중에는 타순을 변경할 수 없다.
 *  9번 타자까지 공을 쳤는데 3아웃이 발생하지 않은 상태면 이닝은 끝나지 않고, 1번 타자가 다시 타석에 선다
 *  타순은 이닝이 변경되어도 순서를 유지해야 한다.
 *  예를 들어, 2이닝에 6번 타자가 마지막 타자였다면, 3이닝은 7번 타자부터 타석에 선다.
 *  공격은 투수가 던진 공을 타석에 있는 타자가 치는 것이다.
 *  공격 팀의 선수가 1루, 2루, 3루를 거쳐서 홈에 도착하면 1점을 득점한다.
 *  타자가 홈에 도착하지 못하고 1루, 2루, 3루 중 하나에 머물러있을 수 있다. 루에 있는 선수를 주자라고 한다. 이닝이 시작될 때는 주자는 없다.
 *  타자가 공을 쳐서 얻을 수 있는 결과는 안타, 2루타, 3루타, 홈런, 아웃 중 하나이다. 각각이 발생했을 때, 벌어지는 일은 다음과 같다.

안타: 타자와 모든 주자가 한 루씩 진루한다.
2루타: 타자와 모든 주자가 두 루씩 진루한다.
3루타: 타자와 모든 주자가 세 루씩 진루한다.
홈런: 타자와 모든 주자가 홈까지 진루한다.
아웃: 모든 주자는 진루하지 못하고, 공격 팀에 아웃이 하나 증가한다.
한 야구팀의 감독 아인타는 타순을 정하려고 한다. 
아인타 팀의 선수는 총 9명이 있고, 1번부터 9번까지 번호가 매겨져 있다. 
아인타는 자신이 가장 좋아하는 선수인 1번 선수를 4번 타자로 미리 결정했다. 
이제 다른 선수의 타순을 모두 결정해야 한다. 아인타는 각 선수가 각 이닝에서 어떤 결과를 얻는지 미리 알고 있다. 가장 많은 득점을 하는 타순을 찾고, 그 때의 득점을 구해보자.
 * 
 * 
 * 
 * 
 * 입력
 * 첫째 줄에 이닝 수 N(2 ≤ N ≤ 50)이 주어진다. 
 * 둘째 줄부터 N개의 줄에는 각 선수가 각 이닝에서 얻는 결과가 1번 이닝부터 N번 이닝까지 순서대로 주어진다. 이닝에서 얻는 결과는 9개의 정수가 공백으로 구분되어져 있다. 
 * 각 결과가 의미하는 정수는 다음과 같다.
 * 안타: 1
 * 2루타: 2
 * 3루타: 3
 * 홈런: 4
 * 아웃: 0
 * 각 이닝에는 아웃을 기록하는 타자가 적어도 한 명 존재한다.
 */

// 풀이 
// 입력 n 이닝을 받음 
// 각 이닝 득점 저장()
// for문 돌려야 순열됨
// 야구선수 순서 정하기 (visited[][] 1는 방문, 선수들[], count);

// ---- 각이닝득점저장
// n 이닝만큼 [n][i] 저장하기 
// 게임 진행하기(arr);

/// 야구선수 순서정하기()
// count = 10 면 return 하기 
//순열임 근데 4는 무조건 1로 
// visited[i] 가 false 방문 안한거일때 선수들[count] = i;
// visited 방문
// 순열(visited, arr, count+1)
// visited = false



// --- 게임 진행하기 (int[] arr)
// for n 을 돌면서 각 이닝 진행 
// 이닝(i, arr// 선수들);


// --- 이닝(int 현재이닝, int[] 선수들 )
// 아웃카운트 = 0 
// 현재 루[4]
// 현재 득점

// while(true}
// 스윙 = 이닝[현재이닝][start] ;
// int count = 계산(루)
// 만양 스윙이 0 이면 아웃 카운트++
// 만약 아웃카운트가 3 이면 break
// start ++
// 만약 start가 9이상이면 start는 0으로 


//------ 계산(루[], int 스윙)
//만약 스윙 = 0 이면 return;
// for(int i = 3 i>=1) 
// 만약 해당 루에 사람이 없음 continue
//  루[i] = false; // 띄기 시작
//  if(i+ 스윙이면) count++
// 그게아님 루[i+스윙] = true; // 해당 루 안착 
public class Main {
	
	static BufferedReader br;
	static StringTokenizer st;
	
	static int n;
	static int 총득점;
	static int max = Integer.MIN_VALUE;
	
	static int[][] 이닝;
	static int 타순 ;
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		이닝구하기();
		
		boolean[] visited = new boolean[10];
		visited[1] = true;
		int[] 선수들 = new int[10];
		for(int i=2; i<10; i++) {
			visited[i] = true;
			선수들[1] = i;
			야구선수순서정하기(visited, 선수들, 2);
			visited[i] = false;
		}
		
		System.out.println(max);
		
	}
	
	private static void 이닝구하기() throws IOException {
		이닝 = new int[n][10];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=9; j++) {
				이닝[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	/// 야구선수 순서정하기()
	// count = 10 면 return 하기 
	//순열임 근데 4는 무조건 1로 
	// visited[i] 가 false 방문 안한거일때 선수들[count] = i;
	// visited 방문
	// 순열(visited, arr, count+1)
	// visited = false
	
	private static void 야구선수순서정하기(boolean[] visited, int[] 선수들 , int count) {
		if(count ==10) {
			게임진행(선수들);
			max = Math.max(max, 총득점);
			return;
		}
		
		if(count == 4) {
			선수들[count] = 1;
			야구선수순서정하기(visited, 선수들, count+1);
			return;
		}
		
		
		for(int i=1; i<=9; i++) {
			if(!visited[i]) {
				visited[i] = true; // 해당 선수 방문 
				선수들[count] = i; // 선수 배열 지목 
				야구선수순서정하기(visited, 선수들, count+1);
				visited[i] = false;
			}
		}
	}
	
	// --- 게임 진행하기 (int[] arr)
	// for n 을 돌면서 각 이닝 진행 
	// 이닝(i, arr// 선수들);

	private static void 게임진행(int[] 선수들) {
		총득점 = 0;
		타순 = 1;
		for(int i=0; i<n; i++) {
			이닝(i, 선수들);
		}
	}
	
	
	// --- 이닝(int 현재이닝, int[] 선수들 )
	// 아웃카운트 = 0 
	// 현재 루[4]
	// 현재 득점

	// while(true}
	// 스윙 = 이닝[현재이닝][start] ;
	// int count = 계산(루)
	// 만양 스윙이 0 이면 아웃 카운트++
	// 만약 아웃카운트가 3 이면 break
	// start ++
	// 만약 start가 9이상이면 start는 0으로 

	
	private static void 이닝(int 현재이닝, int[] 선수들) {
		int outcount = 0;
		boolean[] 루 = new boolean[4];
		
		while(true) {
			int 현재선수 = 선수들[타순];
			int 스윙 = 이닝[현재이닝][현재선수];
			타순++;
			int 현재타자득점 = 계산(스윙, 루);
			총득점 += 현재타자득점;
			if(타순 == 10) {
				타순 = 1;
			}
			if(스윙 == 0) {
				outcount++;
				if(outcount == 3) {
					break;
				}
			}else if(스윙 == 4) {
				총득점 ++;
			}else {
				루[스윙] =  true;
			}
		}
	}
	
	//------ 계산(루[], int 스윙)
	//만약 스윙 = 0 이면 return;
	// for(int i = 3 i>=1) 
	// 만약 해당 루에 사람이 없음 continue
	//  루[i] = false; // 띄기 시작
	//  if(i+ 스윙이면) count++
	// 그게아님 루[i+스윙] = true; // 해당 루 안착 
	private static int 계산(int 스윙, boolean[] 루) {

		if(스윙 == 0) return 0;
		int count = 0;
		
		for(int i=3; i>=1; i--) {
			if(!루[i]) {
				continue; // 사람이 없음
			}
			루[i] = false; // 뛰기
			
			if(i+스윙 > 3) {
				count++;
			}else {
				루[i+스윙] = true; // 도달
			}
		}
		
		return count;
	}
}
