import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    static  int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            if (num == 0){

                if(!priorityQueue.isEmpty()){
                    System.out.println(priorityQueue.poll());
                }else{
                    System.out.println(0);
                }
            }else{
                priorityQueue.add(num);
            }
        }


    }
}
