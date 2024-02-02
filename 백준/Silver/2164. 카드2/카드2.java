import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Deque<Integer> queue = new LinkedList<>();
        for(int i=0; i<n; i++){
            queue.add(i+1);
        }

        while(queue.size()!=1){
            queue.pollFirst();// 가장 첫번째꺼 삭제

            int delete = queue.pollFirst(); //
            queue.add(delete); // 가장 뒤에 추가
        }

        System.out.println(queue.poll());



    }
}