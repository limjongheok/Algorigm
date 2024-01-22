import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String f= br.readLine();
        String d = br.readLine();
        
        if(f.length()>= d.length()){
            System.out.println("go");
        }else{
            System.out.println("no");
        }
    }
}