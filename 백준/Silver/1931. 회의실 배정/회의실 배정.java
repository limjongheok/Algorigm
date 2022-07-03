import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int[][] room = new int[input][2];

        for(int i=0; i<input; i++){
            room[i][0] = sc.nextInt(); // 시간 시간 지정
            room[i][1] = sc.nextInt(); // 끝시간 지정
        }

        // 종료 시간 오름 차순 정렬
        Arrays.sort(room, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]){
                    return o1[0]-o2[0];
                }else{
                    return  o1[1]-o2[1];
                }
            }
        }); // 2차원 배열 정렬


        //확인
//        for (int i=0; i<input; i++){
//            for(int j=0; j<2; j++){
//                System.out.println(room[i][j]);
//            }
//        }

        int end = 0;
        int count = 0 ;

        for(int i=0; i< input; i++){
            if(end<=room[i][0]){//현재 시작시간이 종료 시간 보다 클경우
                count = count +1;
                end = room[i][1];

            }
        }
        System.out.println(count);
    }
}
