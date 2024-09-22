import java.io.*;
import java.util.*;

/** 
s 문자열이 들어와 n 만큼 밀림
**/
class Solution {
    static String answer = "";
    public String solution(String s, int n) {
        
        // 문자열 밀기 
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != ' '){
                pullString(s.charAt(i), n);
            }else {
                answer += " ";
            }
            
        }
        
        return answer;
    }
    
    private static void pullString(char c, int n) {
        System.out.println(c);
        int num =  (int) c;
        if(n == 0){
            answer += String.valueOf(c);
            return;
        }
        
        if(c == 'z') {
            pullString('a' , n-1);
        } else if(c == 'Z') {
            pullString('A' , n-1);
        }else {
            pullString((char) (num+1) , n-1);
        }
        
        
    }
}