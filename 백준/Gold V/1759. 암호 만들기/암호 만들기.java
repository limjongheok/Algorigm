import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
 private  static char [] cs;
    private static  int[] gather;
    private static int l;
    private static int c;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 입력 l c
         l = Integer.parseInt(st.nextToken());
         c = Integer.parseInt(st.nextToken());

        // c 의 공백 문자열
        cs = new char[c];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<c; i++){
            cs[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(cs); //1. 문자 입력 받고 오름 차순



        // 조합
        // c 개중 자음 2 개를 뽑아라
        boolean[] visited = new boolean[c];
        gather = new int[c];
        comP(0,0, 0,0,visited, "");


    }
    // 6개 중 4개를 뽑을거임
    private static void comP(int idx, int countG,int countC,int count , boolean[] visited, String s){ // 인덱스, 모음 수, 전체 수 , 방문 체크
        if(count == l && countG >=1 && countC >=2){
            System.out.println(s);
            return;
        }
        for(int i=idx; i<c; i++){
            if(!visited[i]){
                visited[i] = true;
                if(cs[i] == 'a' || cs[i] == 'e' || cs[i] =='i' || cs[i] =='o' || cs[i] == 'u' ){
                    comP(i,countG+1,countC,count+1,visited,s+cs[i]);
                }else{
                    comP(i,countG,countC+1,count+1,visited,s+cs[i]);
                }
                visited[i] = false;
            }
        }

    }
}