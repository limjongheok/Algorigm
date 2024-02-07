import java.io.*;
import java.util.*;


public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		boolean[][] arr = new boolean[101][101]; // 가로 세로 100인 색종이 
		int sum = 0;
		for(int i=0; i<n; i++) {
			// 세로 가로 크기 각 10인 도화지 붙이기 
		    st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken()); // 좌 
			int bottom = Integer.parseInt(st.nextToken());
			
			int leftEnd = left+10;
			int bottomEnd = 100-bottom;
			for(int l = left; l<leftEnd; l++) {
				for(int b = bottomEnd - 9; b<=bottomEnd; b++) {
					arr[l][b] = true;
				}
			}
		}
		
		int count = 0;
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(arr[i][j]) {
					count++;
				}
			}
		}
		System.out.println(count);
	}

}