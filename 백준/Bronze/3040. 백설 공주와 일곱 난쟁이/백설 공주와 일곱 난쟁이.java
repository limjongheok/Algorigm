import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<Integer> nannum = new ArrayList<Integer>();
        for(int i= 0; i<9; i++){
            int num = sc.nextInt();
            nannum.add(num);
        }// 난쟁이 모자 수를 직접 입력하여 배열에 넣기

        //리스트 합치기
        int sum = nannum.stream().mapToInt(Integer::intValue).sum();

        //2개 찾아서 빼서 100만들기

        for(int i =0; i<9; i++){


            for(int j =1; j<9; j++){
                if(i<j){
                    if(sum - nannum.get(i)- nannum.get(j)==100){

                        for(int number: nannum){
                            if(number != nannum.get(i) && number != nannum.get(j)){
                                System.out.println(number);
                            }
                        }

                    }

                }


            }
        }





    }
}
