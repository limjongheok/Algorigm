import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b = br.readLine();
        String c = "";
        for(int i=0; i<a.length(); i++){
            c+= String.valueOf(a.charAt(i)) + String.valueOf(b.charAt(i));

        }
        System.out.println(dp(c));



    }

    public static String dp( String c){
        if(c.length() == 2){
            return c;

        }
        String t= "";
        for(int i=0; i<c.length()-1; i++ ){
            int a = Integer.parseInt(String.valueOf(c.charAt(i)));
            int b = Integer.parseInt(String.valueOf(c.charAt(i+1)));
            int c1 = a+b;
            String s = String.valueOf(c1);
            s = String.valueOf(s.charAt(s.length()-1));

            t+= s;

        }
        

        return dp(t);
    }
}