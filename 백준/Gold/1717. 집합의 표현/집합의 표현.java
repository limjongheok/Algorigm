import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
 private static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n+1];

        for(int i=0; i<=n; i++){ // n+1 까지 처음 합 집합 공간은 0으로 있음
            arr[i] = i;
        }
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<m; i++) { // 연산 수

            st = new StringTokenizer(br.readLine());
            int cal = Integer.parseInt(st.nextToken()); // 연산
            int one = Integer.parseInt(st.nextToken()); // 첫 집합수
            int two = Integer.parseInt(st.nextToken()); //두번째 집합수

            switch (cal){
                case 0: // 합침
                    union(one, two);
                    break;
                case 1:
                    int first = find(one);
                    int sec = find(two);
                    if(first == sec){
                        sb.append("YES");
                        sb.append("\n");
                    }else {
                        sb.append("NO");
                        sb.append("\n");
                    }
            }
        }
        System.out.println(sb);
    }

    private static void union(int one, int two){
       int first = find(one);
       int second = find(two); // 제일 루트 연결 좌표를 찾아서 더 작은 거랑 연결

        if(first!=second){
            if(first > second){
                arr[first] = second;
            }else{
                arr[second] = first;
            }
        }
    }

    private static int find(int num){
        if(arr[num] == num){ // 만약 내가 배열의 나의 위치랑 같으면 루트
            return num;
        }else{
            return arr[num] = find(arr[num]); // 아니면 해당 노드에 들어감
        }
    }
}

