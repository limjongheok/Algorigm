import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());


        int sum = 0;
        for(int i=1; i<=n; i++){
            String s = String.valueOf(i);



          
            sum += Integer.parseInt(s);


            for(int j=0; j<s.length(); j++){
              ;
                sum += Integer.parseInt(String.valueOf(s.charAt(j)));
            }
            if(sum == n){
                sum =Integer.parseInt(s);
                break;
            }else{
                sum =0;
            }

        }
        System.out.println(sum);



    }
}