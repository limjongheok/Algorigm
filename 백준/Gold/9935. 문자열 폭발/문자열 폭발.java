import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  private static String input;
    private static String bum;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 문자열 입력
         input = br.readLine();
        // 폭발 문자열 입력
         bum = br.readLine();

         Stack<Character> stack = new Stack<>();
         for(int i=0; i<input.length(); i++){
             stack.push(input.charAt(i));

             boolean check  = false;
             if(stack.size() >= bum.length()){
                 // 스택에서 제거
                 for(int j=0; j<bum.length(); j++){
                     if(bum.charAt(j) != stack.get(stack.size()-bum.length()+j)){
                         check = true; // 같지 않은게 있다면 true
                         break;
                     }
                 }
                 if(!check){ // true 있다면 스텍에서 지우기
                     for(int j=0; j<bum.length(); j++ ){
                         char c  = stack.pop();
                     }
                 }
             }

         }
         if(stack.isEmpty()){
             System.out.println("FRULA");
         }else{
             StringBuilder sb = new StringBuilder();
             for(Character c : stack){
                 sb.append(c);
             }
             System.out.println(sb);
         }
    }


}

