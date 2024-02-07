import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	private static List[] arr;
	private static List[] angleArr; // 90도 회전용 arr
	private static List[][] divisonArr;
	private static int n;
	private static int m;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 배열 크기 
		st = new StringTokenizer(br.readLine());
		 n = Integer.parseInt(st.nextToken());
		 m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken()); // 연산
		
	    arr = new List[n];
	 
	    for(int i=0; i<n; i++) {
	    	List<Integer> list = new ArrayList();
	    	st = new StringTokenizer(br.readLine());
	    	for(int j=0; j<m; j++) {
	    		list.add(Integer.parseInt(st.nextToken()));
	    	}
	    	arr[i] = list;
	    }
	    st = new StringTokenizer(br.readLine());
	    for(int order= 0; order<r; order++) {
	    	int o = Integer.parseInt(st.nextToken());
	    	switch (o){
			case 1:
				upDown();
				break;
			case 2:
				leftRight();
				break;
			case 3:
	    		right90();
	    		break;
			case 4:
				left90();
				break;
			case 5:
	    		division(5);
	    		break;
			case 6:
	    		division(6);
	    		break;
	    	}
	    
	    	
	    }
	    
	    StringBuilder sb = new StringBuilder();
	    
	    for(int i=0; i<arr.length; i++) {
	    	for(int j=0; j<arr[i].size(); j++) {
	    		sb.append(arr[i].get(j) + " ");
	    	}
	    	sb.append("\n");
	    }
	    System.out.println(sb);
	}
	
	public static void upDown() { // up down
		List[] arr2 = new List[arr.length];
		int count =0;
		for(int i=arr.length-1; i>=0; i--) {
			arr2[count] = arr[i];
			count++;
		}
		arr =arr2;

	}
	
	public static void leftRight() {// left right
		List[] arr2 = new List[arr.length];
		for(int i=0; i<arr.length; i++) {
			List<Integer> list2 = new ArrayList();
			for(int j=arr[i].size()-1; j>=0; j--) {
				list2.add((Integer)arr[i].get(j));
			}
			arr2[i] = list2; 
		}
		
		arr = arr2;

	}
	
	private static void right90() {// 오른쪽 90도
		angle(); // 각도용 리스트 만들기 
		arr = angleArr;
		leftRight(); // 좌우반전

		
	}
	private static void left90() {
		
		angle();
		arr = angleArr;
		upDown();
	}
	
	private static void division(int num) {
		int divisonN = arr.length/2;
		List[] arr1 = new List[divisonN];
		List[] arr2 = new List[divisonN];
		List[] arr3 = new List[divisonN];
		List[] arr4 = new List[divisonN];
		List<List[]> lists = new ArrayList();

		for(int i=0; i<divisonN; i++) {
			List<Integer> divisionList  = new ArrayList();
			for(int j=0; j<arr[i].size()/2; j++) {
				divisionList.add((Integer)arr[i].get(j));
			}
			arr1[i] = divisionList;
		}
		
		
		for(int i=0; i<divisonN; i++) {
			List<Integer> divisionList  = new ArrayList();
			for(int j=arr[i].size()/2; j<arr[i].size(); j++) {
				divisionList.add((Integer)arr[i].get(j));
			}
			arr2[i] = divisionList;
		}
		

	
		for(int i=divisonN; i<arr.length; i++) {
			List<Integer> divisionList  = new ArrayList();
			for(int j=0; j<arr[i].size()/2; j++) {
				divisionList.add((Integer)arr[i].get(j));
			}
			// 어디에 저장
			arr4[i-divisonN] = divisionList;
		}
	
		
		for(int i=divisonN; i<arr.length; i++) {
			List<Integer> divisionList  = new ArrayList();
			for(int j=arr[i].size()/2; j<arr[i].size(); j++) {
				divisionList.add((Integer)arr[i].get(j));
			}
			// 어디에 저장
			arr3[i-divisonN] = divisionList;
		}
		
		
		if(num==5) {
			division5(arr1,arr2,arr3,arr4);
		}else {
			division6(arr1,arr2,arr3,arr4);
		}
		
	
		
	}
	
	private static void division5(List[] arr1, List[] arr2 ,List[] arr3 ,List[] arr4) { // 5번 1->2 2-3 3->4 4->1
		List[] arrs = new List[arr.length];
		int count = 0;
		for(int i=0; i<arr4.length; i++) {
			List<Integer> list = new ArrayList();
			for(int j=0; j<arr4[i].size(); j++) {
				list.add((Integer)arr4[i].get(j));
			}
			for(int j=0; j<arr1[i].size(); j++) {
				list.add((Integer)arr1[i].get(j));
			}
			arrs[count] = list;
			count++;
		}
		
		for(int i=0; i<arr3.length; i++) {
			List<Integer> list = new ArrayList();
			for(int j=0; j<arr3[i].size(); j++) {
				list.add((Integer)arr3[i].get(j));
			}
			for(int j=0; j<arr2[i].size(); j++) {
				list.add((Integer)arr2[i].get(j));
			}
			arrs[count] = list;
			count++;
		}
		arr = arrs;

	}
	
	
	private static void division6(List[] arr1, List[] arr2 ,List[] arr3 ,List[] arr4) { // 5번 1->2 2-3 3->4 4->1
		List[] arrs = new List[arr.length];
		int count = 0;
		for(int i=0; i<arr2.length; i++) {
			List<Integer> list = new ArrayList();
			for(int j=0; j<arr2[i].size(); j++) {
				list.add((Integer)arr2[i].get(j));
			}
			for(int j=0; j<arr3[i].size(); j++) {
				list.add((Integer)arr3[i].get(j));
			}
			arrs[count] = list;
			count++;
		}
		
		for(int i=0; i<arr1.length; i++) {
			List<Integer> list = new ArrayList();
			for(int j=0; j<arr1[i].size(); j++) {
				list.add((Integer)arr1[i].get(j));
			}
			for(int j=0; j<arr4[i].size(); j++) {
				list.add((Integer)arr4[i].get(j));
			}
			arrs[count] = list;
			count++;
		}
		arr = arrs;
	
	}
	
	private static void angle() {
		int m = arr[0].size();
		angleArr = new List[m];
		int n = arr.length;
		for(int i=0; i<m; i++) {
	    	List<Integer> list = new ArrayList();
	    	for(int j=0; j<n; j++) {
	    		list.add((Integer)arr[j].get(i));
	    	}
	    	angleArr[i] = list;
	    }
	    
	}
	
}