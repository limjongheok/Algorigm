import java.io.*;
import java.util.*;
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s= br.readLine();
        String r = "";
        for(int i=0; i<s.length(); i++){
            r += String.valueOf(s.charAt(i));
            if(i%10==9){
                System.out.println(r);
                r="";
            }
        }
        if(!r.equals("")){
            System.out.println(r);
        }
    }
}