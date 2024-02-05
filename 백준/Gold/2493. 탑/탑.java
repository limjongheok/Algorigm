import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
   public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        int n=Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stackPop = new Stack<>();
        Stack<Integer> stackSize = new Stack<>();
        for(int i=0; i<n; i++){
            stack.add(Integer.parseInt(st.nextToken()));
        }

        while(!stack.isEmpty()){


            if(stackPop.isEmpty()){
                int size = stack.size(); //5
                stackSize.add(size);
                stackPop.add(stack.pop());
            }else{
                if(stack.peek() >= stackPop.peek()){
                    stackPop.pop();
                    int sizeNum = stackSize.pop();
                    arr[sizeNum-1] =  stack.size();
                }else{
                    int size = stack.size();
                    stackSize.add(size);
                    stackPop.add(stack.pop());
                }
            }
           
        }
        StringBuilder sb = new StringBuilder();
        for(int i : arr){
            sb.append(i+" ");
        }
        System.out.println(sb);

    }
}