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
import java.util.*;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	private static boolean check;
    private static int[][] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
      arr = new int[9][9];

        int tc = Integer.parseInt(br.readLine());

        for(int t=1; t<=tc; t++){
            for(int i=0; i<9; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<9; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            } // 배열 채우기

             check = true;

            //새로

            for(int i=0; i<9; i++){
                Map<Integer, Integer> map = new HashMap<>();
                for(int j=0; j<9; j++){
                    if(map.containsKey(arr[i][j])){
                        check = false;
                        break;
                    }else{
                        map.put(arr[i][j],1);
                    }
                }
            }


            // 세로
            for(int i=0; i<9; i++){
                Map<Integer, Integer> map = new HashMap<>();
                for(int j=0; j<9; j++){
                    if(map.containsKey(arr[j][i])){
                        check = false;
                        break;
                    }else{
                        map.put(arr[j][i],1);
                    }
                }
            }

            for(int i=0; i<9; i+=3){
                for(int j=0; j<9; j+=3){
                    grid(i,j);
                }
            }
            if(!check){
                System.out.println("#"+ t+" " + 0);
            }else{
                System.out.println("#"+ t+" " + 1);
            }
        }
    }
        private static void grid(int x, int y){
            Map<Integer,Integer> map = new HashMap<>();
            for(int i=x; i<=x+2; i++){
                for(int j=y; j<=y+2; j++){
                    if(map.containsKey(arr[i][j])){
                        check =false;
                        break;
                    }else{
                        map.put(arr[i][j],1);
                    }
                }
            }
        }
}