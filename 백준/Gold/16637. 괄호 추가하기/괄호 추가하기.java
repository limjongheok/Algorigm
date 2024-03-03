import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static  int size;
    static int[] ca;
    static char[] bu;
    static int max;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
         ca= new int[n/2+1];
         bu = new char[n/2];

        size = bu.length;
        String s = br.readLine();
        int countO = 0;
        int countT = 0;
        for(int i=0; i<n; i++){
            if(s.charAt(i)!='+'&& s.charAt(i)!='-' && s.charAt(i) != '*'){
                ca[countO] = Character.getNumericValue(s.charAt(i));
                countO++;
            }else{
                bu[countT] = s.charAt(i);
                countT++;
            }
        }

        max = Integer.MIN_VALUE;
        dfs(ca[0],0);
        System.out.println(max);
    }
    private static void dfs(int result, int idx){
        if(idx == size){
            max = Math.max(result,max);
            return;
        }

        // 괄호 없을시
        dfs(cal(result,ca[idx+1],bu[idx]),idx+1);

        if(idx+1< size){
            // 우측에 괄호 두기
            // 우측 계산
            int re = cal(ca[idx+1],ca[idx+2],bu[idx+1]);
            // 좌측 합치기
            int re2 = cal(result,re,bu[idx]);
            dfs(re2,idx+2);
        }
    }

    private static int cal(int a, int b, char bu){
        if(bu == '+'){
            return a+b;
        }
        if(bu == '*'){
            return a*b;
        }
        if(bu == '-'){
            return a-b;
        }

        return 0;

    }
}
