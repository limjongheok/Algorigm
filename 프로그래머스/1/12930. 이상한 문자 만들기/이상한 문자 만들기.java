/**
짝수 번째 알파벳은 대문자 
홀수 번째 알파벳 소문자로 
**/
// 소문자 a 97 122
// 대문자 A 65 90 둘의 차는 32
class Solution {
    public static String answer = "";
    public String solution(String s) {
        String answer = "";
        String[] strs = s.split(" ", -1);
    
        for (int i=0; i<strs.length; i++) {
            String str = strs[i];
            for (int j=0; j<str.length(); j++) {
                char c = str.charAt(j);
                
                if (j % 2 == 0) {
                    c = Character.toUpperCase(c);
                } else {
                    c = Character.toLowerCase(c);
                }
                answer += c;
            }
            if (i == strs.length-1) break;
            answer += " ";
        }
   
        return answer;
      
    }
    
    
}