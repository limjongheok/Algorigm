import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static boolean[] visited;
    private static String 수식;
    private static  int 수식길이;
    private static int[] 숫자배열인풋;
    private static int max;
    private static int min;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
      숫자배열인풋 = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            숫자배열인풋[i] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            int num = Integer.parseInt(st.nextToken());
            switch (i){
                case 0:
                    for(int j=0; j<num; j++){
                        sb.append("+");
                    }
                        break;
                case 1:
                    for(int j=0; j<num; j++){
                        sb.append("-");
                    }
                    break;
                case 2:
                    for(int j=0; j<num; j++){
                        sb.append("*");
                    }
                    break;
                case 3:
                    for(int j=0; j<num; j++){
                        sb.append("%");
                    }
                    break;
            }

        }
        수식 = sb.toString();
        수식길이 = 수식.length();
        visited = new boolean[수식길이];
        char[] 수식재조합 = new char[수식길이];
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        re(0,수식재조합);
        System.out.println(max);
        System.out.println(min);
    }

    private static void re(int start, char[] 수식재조합){
        if(start == 수식길이){
            // 수식 재조합이 다 차면 수식재조합을 빼 숫자 배열 계산
            int sum = 숫자배열인풋[0];
            for(int i=0; i<수식재조합.length; i++){
                switch (수식재조합[i]){
                    case '+':
                        sum = sum + 숫자배열인풋[i+1];
                        break;
                    case '-':
                        sum = sum - 숫자배열인풋[i+1];
                        break;
                    case '*':
                        sum = sum * 숫자배열인풋[i+1];
                        break;
                    case '%':
                        sum = sum / 숫자배열인풋[i+1];
                        break;
                }

            }
            if(sum > max){
                max = sum;
            }
            if(sum < min){
                min = sum;
            }
            return;
        }

        for(int i=0; i<수식길이; i++){
            if(!visited[i]){
                visited[i] = true;
                수식재조합[start] = 수식.charAt(i);
                re(start+1, 수식재조합);
                visited[i] = false;
            }
        }
    }
}