import java.io.*;
import java.util.*;

class Main{
    public static  void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            String s = st.nextToken();
            if(s.equals("push")){
                int a = Integer.parseInt(st.nextToken());
                stack.add(a);
            }

            if(s.equals("pop")){
                if(!stack.isEmpty()){
                    System.out.println(stack.pop());
                }else{
                    System.out.println(-1);
                }
            }

            if(s.equals("size")){
                System.out.println(stack.size());
            }

            if(s.equals("empty")){
                if(stack.isEmpty()){
                    System.out.println(1);
                }else {
                    System.out.println(0);
                }

            }

            if(s.equals("top")){
                if(stack.isEmpty()){
                    System.out.println(-1);
                }else{
                    System.out.println(stack.peek());
                }
            }
        }

    }
}