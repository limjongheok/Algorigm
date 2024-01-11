import java.io.*;
import java.util.*;


class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        
        String[] splitS = s.split("-");
        
        for(int i=0; i<splitS.length; i++){
            
            // 현재 값 
            String sp = splitS[i];
            boolean check = true;
            
            // plus 이면 
            for(int j=0; j<sp.length(); j++){
                if(sp.charAt(j) == '+'){
                    check = false;
                }
            }
            if(!check){
                String[] splitSp = sp.split("\\+");
                int sum = 0;
                for(int j=0; j<splitSp.length; j++){
                    sum += Integer.parseInt(String.valueOf(splitSp[j]));
                }
                splitS[i] = Integer.toString(sum);
            }
            check = true;
        }
        int result = Integer.parseInt(splitS[0]);
        for(int i=1; i<splitS.length; i++){
            result -= Integer.parseInt(splitS[i]);
        }
        System.out.println(result);
        
        
    }
}