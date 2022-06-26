import java.util.*;

public class Main{

    public static List<Integer> maxeat= new ArrayList<>();
    public static void result(char[][] candy , int input){
        int ans =1;
        int count =1;
        // 바끼는거 증명
       // for(int i=0; i<input; i++){
        //    for(int j=0; j<input; j++){
          //      System.out.print(candy[i][j]);
       //     }
        //    System.out.println();
      //  }

        // 열을 탐색해서 숫자 세기
        for(int i=0; i<input; i++){
            for(int j=0; j<input-1; j++){
                if(candy[i][j] == candy[i][j+1]){
                    count = count+1;

                    if(count>ans) {
                        ans = count;
                    }
                }
                else{
                    count= 1;
                }
            }
            count =1;
        }

        //행
        for(int j=0; j<input; j++){
            for (int i=0; i<input-1; i++){
                if(candy[i][j] == candy[i+1][j]){
                    count =count+1;

                    if(count>ans){
                        ans= count;
                    }
                }
                else{
                    count= 1;
                }


            }
            count =1;
        }




        maxeat.add(ans);



    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        //문자열 배열 선언
        char[][] candy = new  char[input][input];

        for(int i=0; i<input; i++){
            String color = sc.next(); // string 을 값을 입력을 받아
            for(int j=0; j<color.length(); j++){
                candy[i][j] = color.charAt(j); // 문자형식으로 변환

            }
        }
        // 열 변화
        for(int i=0; i<input; i++){
            for(int j=0; j<input-1; j++){
                if(candy[i][j] != candy[i][j+1]){
                    //변환
                    char color = candy[i][j];
                    candy[i][j] = candy[i][j+1];
                    candy[i][j+1] = color;
                    // 함수 선언
                    result(candy, input);
                    //원상복구
                    candy[i][j+1] = candy[i][j];
                    candy[i][j] = color;

                }
            }
        }
        // 행 변화
        for(int j=0; j<input; j++){
            for(int i=0; i<input-1; i++){
                if(candy[i][j] != candy[i+1][j]){
                    char color = candy[i][j];
                    candy[i][j] = candy[i+1][j];
                    candy[i+1][j] = color;
                    result(candy, input);

                    //복구
                    candy[i+1][j] = candy[i][j];
                    candy[i][j] = color;
                }
            }
        }

        //maxeat 에서 최대값 구하기
        int max = maxeat.get(0);

        for(int i=1; i<maxeat.size(); i++){
            if(maxeat.get(i)> max){
                max = maxeat.get(i);
            }
        }

        System.out.println(max);





    }
}
