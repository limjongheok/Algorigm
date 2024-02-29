
import java.io.*;
import java.util.*;

public class Solution {
	private static int n;
	private static int[][] arr;
	private static boolean[][] visited;
	private static Queue<Node> queue = new LinkedList<>();
	private static Queue<Node> queue2 = new LinkedList<>();
	static List<Node> lists;
	private static int size;
	private static boolean[] vi;
	private static int[] dx = {-1,1};
	private static int[] dy = {1,-1};
	private static int count;
	private static int min;
	private static boolean che;
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=tc; t++) {
			 n = Integer.parseInt(br.readLine());
			 
			 arr = new int[n][n];
			 visited = new boolean[n][n];
			lists = new ArrayList();
			 for(int i=0; i<n; i++) {
				 st = new StringTokenizer(br.readLine());
				 for(int j=0; j<n; j++) {
					 arr[i][j] = Integer.parseInt(st.nextToken());
					
					 if(i!=0 && j!=0 && j!=n-1 && j!=n-1 &&  arr[i][j] ==1) {
						 lists.add(new Node(i,j,0));
					 }
					 if(arr[i][j] == 1) visited[i][j] = true;
 				 }
			 }
			  
			 min = Integer.MAX_VALUE;
			 
			 for(int i=lists.size(); i>=1; i--) {
				 che = false;
				 Node[] nodes = new Node[i];
				 size = i;
				 vi = new boolean[lists.size()];
				 int[][] copy = new int[n][n];
				 copyVisited(copy,arr);
				 int c = 0;
				 dfs(0,0,nodes,copy,c);
				 if(che) break;
			 }
			 System.out.println("#" + t + " " +min);
			 
		}
	}
	
	private static void dfs(int idx, int v, Node[] nodes,int[][] copy, int c) {
		
		if(idx == size) {
			min = Math.min(c, min);
			che = true;
			return;
		}
		
		for(int i=v; i<lists.size(); i++) {
			if(!vi[i]) {
				vi[i] = true;
				for(int j=0; j<4; j++) {
					Node node = lists.get(i);
					node.dir = j;
					nodes[idx] = node;
					count  = c;
					if(checkCore(node,copy)) {
						int [][] arr2 = new int[n][n];
						arr2 = copyVisited(arr2,copy);
						arr2  = core(node, arr2);
						dfs(idx+1,i+1,nodes,arr2,count);
					}
				}
				vi[i] = false;
			}
		}
	}
	
private static int[][] core(Node node, int[][] copy) {
		
		int x = node.x;
		int y = node.y;
		int dir = node.dir;
		
		if(dir == 0) {
			// 위 
			while(true) {
				x = x+dx[0];
				if(x>=0 && x<n) {
					copy[x][y] = 1;
				}else {
					break;
				}
			}
		}
		if(dir == 1) { // 우
			while(true) {
				y = y+dy[0];
				if(y>=0 && y<n) {
					copy[x][y] = 1;
				}else {
					break;
				}
			}
			
			
		}
		if(dir == 2) {// 하
			while(true) {
				x = x+dx[1];
				if(x>=0 && x<n) {
					copy[x][y] = 1;
				}else {
					break;
				}
			}
		}
		if(dir == 3) { //좌
			while(true) {
				y = y+dy[1];
				if(y>=0 && y<n) {
					copy[x][y] = 1;
				}else {
					break;
				}
			}
			
		}
		return copy;
	}
	
	private static boolean checkCore(Node node, int[][] copy) {
		
		int x = node.x;
		int y = node.y;
		int dir = node.dir;
		
		if(dir == 0) {
			// 위 
			while(true) {
				x = x+dx[0];
				if(x>=0 && x<n) {
					if(copy[x][y] == 1) return false;
					count++;
					if(count > min) return false;
				}else { //끝까지 간경우
					return true;
				}
			}
		}
		if(dir == 1) { // 우
			while(true) {
				y = y+dy[0];
				if(y>=0 && y<n) {
					if(copy[x][y] == 1) return false;
					count++;
					if(count > min) return false;
				}else { //끝까지 간경우
					return true;
				}
			}
			
			
		}
		if(dir == 2) {// 하
			while(true) {
				x = x+dx[1];
				if(x>=0 && x<n) {
					if(copy[x][y] == 1) return false;
					count++;
					if(count > min) return false;
				}else { //끝까지 간경우
					return true;
				}
			}
			
			
			
		}
		if(dir == 3) { //좌
			while(true) {
				y = y+dy[1];
				if(y>=0 && y<n) {
					if(copy[x][y] == 1) return false;
					count++;
					if(count > min) return false;
				}else { //끝까지 간경우
					 return true;
				}
				
			}
			
		}
		return true;
	}
	
	private static int[][] copyVisited(int[][] copy, int[][] arr) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				copy[i][j] = arr[i][j];
			}
		}
		return copy;
	}
	private static void print(int copy[][]) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(copy[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	private static class Node{
		int x;
		int y;
		int dir;
		
		public Node(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			
		}
	}

}