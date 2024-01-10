import java.io.*;
import java.util.*;
class Main{
    private static int[] arr;
    private static  Queue<Integer> queue;
    private static int k;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        arr=  new int[100001];
         arr[n] =1;
        bfs(n);
        System.out.println(arr[k]-1);
        
    }
    
    private static void bfs(int x){
        queue = new LinkedList<Integer>();

        
        queue.add(x);
        
        while(!queue.isEmpty()){
            int nowX = queue.poll();
            
            if(arr[k]!=0) break; // 그러나 동생의 위치값이 0이 아니면 이미 최솟값을 찾은 것이므로 벗어난다.
								   // 배열의 크기를 100,001로 해서 시간을 조금이라도 단축시키기 위함
			if((nowX-1>=0) && arr[nowX-1]==0) { // 이 부분에서 많은 분들이 런타임 에러가 많이 발생하는 것 같다.
				queue.add(nowX-1);  			// 조건부의 x범위를 먼저 확인해줘야 뒤에 배열 인덱스를 참조할 때 범위를 벗어나지 않는다.
				arr[nowX-1] = arr[nowX]+1; //이동할 수 있는 경우 x-1
			}
			if((nowX<arr.length-1)&&arr[nowX+1]==0) {
				queue.add(nowX+1);
				arr[nowX+1] = arr[nowX]+1; //이동할 수 있는 경우 x+1
			}
			if((nowX*2<arr.length)&&arr[2*nowX]==0) {
				queue.add(2*nowX);
				arr[2*nowX] = arr[nowX]+1; //이동할 수 있는 경우 순간이동 x*2
			}
        }
        
        
    }
    
}