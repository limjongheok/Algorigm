import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(long n) {
        
        String s = String.valueOf(n);
        Stack stack = new Stack();
        int[] answer = new int[s.length()];
        for(int i=0; i<s.length(); i++) {
            String sc = String.valueOf(s.charAt(i));
            stack.add(sc);
        }
        
        for(int i=0; i < s.length(); i++){
            String popString = (String) stack.pop();
            answer[i] = Integer.parseInt(popString);
        }
        return answer;
    }
}