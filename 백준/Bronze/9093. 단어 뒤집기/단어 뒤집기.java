import java.io.*;
import java.util.*;

class Main{
     public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i =0; i<n; i++){
            Stack<String> stack = new Stack<>();
            String s = br.readLine();
            StringBuilder sb = new StringBuilder();


            for(int j=0; j<s.length(); j++){
                String c= String.valueOf(s.charAt(j));


               if(!c.equals(" ")){
                  
                   stack.add(c);
               }else{
                   while(!stack.isEmpty()){
                       sb.append(stack.pop());
                   }
                   sb.append(" ");
               }

            }

            while(!stack.isEmpty()){
                sb.append(stack.pop());
            }

            System.out.println(sb);

        }
    }
}