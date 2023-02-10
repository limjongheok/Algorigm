import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    static  int N;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> queue = new PriorityQueue<>(
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        if(Math.abs(o1)>Math.abs(o2)){
                            return Math.abs(o1) - Math.abs(o2);
                        }else if (Math.abs(o1) == Math.abs(o2)){
                            return o1-o2;
                        }else{
                            return -1;
                        }
                    }
                }

        );

        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0) {
                if (!queue.isEmpty()) {
                    // 배열이 비어 있지 않을시
                    // 절대값 가장 작은 값을 출력
                    // 그 값을 배열에서 제거
                    System.out.println(queue.poll());

                } else {
                    // 그게 아닐 경우 0 출력
                    System.out.println(0);
                }
            }else{
                // num 이 0 이 아닐 경우 0을 넣기
                queue.add(num);

            }
        }

    }
}
