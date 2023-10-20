import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] num = new String[n];
        String s = br.readLine();
        String[] ap = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};

        for(int i=0; i<n; i++){
            num[i] = String.valueOf(s.charAt(i));
        }

        int sum = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<26; j++){
                if((num[i].equals(ap[j]))){
                    if(i==0){
                        sum += (j+1)*1;
                    }else{
                        sum += (j+1) * ji(i);
                    }

                }
            }
        }
        System.out.println(sum);


    }
    public static int ji(int i){
        if(i==1){
            return 31;
        }
        return 31*ji(i-1);
    }
}