/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.io.*;
import java.util.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    
     private static int n;
    private static int m;
    private static int[] 점수;
    private static int[] 칼로리;
    private static boolean[] visited;
    private static int max ;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int tc = 1; tc<=t; tc++){
            st = new StringTokenizer(br.readLine());

             n =Integer.parseInt(st.nextToken());
             m = Integer.parseInt(st.nextToken());

             점수 = new int[n];
             칼로리 = new int[n];
             visited = new boolean[n];

            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                점수[i] = Integer.parseInt(st.nextToken());
                칼로리[i] = Integer.parseInt(st.nextToken());

            }

            max =  Integer.MIN_VALUE;

            re(0,0,0);
            System.out.println("#"+tc+ " "+ max);
        }
    }
    private static void re(int start, int 칼로리_sum, int 점수_sum){
        if(칼로리_sum>m) return;
        if(start ==n){

                if(max<점수_sum){
                    max = 점수_sum;
                }
            return;
        }



        re(start+1, 칼로리_sum+칼로리[start], 점수_sum +점수[start]);
        re(start+1, 칼로리_sum, 점수_sum);


    }
}