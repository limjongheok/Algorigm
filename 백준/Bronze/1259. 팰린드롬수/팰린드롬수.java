import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";

        Boolean b ;
        while(!(s=br.readLine()).equals("0")){
            List<String> list = new ArrayList();
            List<String> list2 = new ArrayList();
            b = true;
            if(s.length() ==1){
                System.out.println("yes");
                continue;
            }
            if(s.length()%2==0){
                int n = s.length()/2; //2
                for(int i=0; i<n; i++){ // 0 1
                    list.add(String.valueOf(s.charAt(i)));
                }
                for(int i=s.length()-1; i>=n; i--){ //3 2
                    list2.add(String.valueOf(s.charAt(i)));
                }
                for(int i=0; i<list.size(); i++){

                    if(!list.get(i).equals(list2.get(i))){
                        b = false;
                    }
                }
            }else{
                int n = s.length()/2;
                for(int i=0; i<n; i++){
                    list.add(String.valueOf(s.charAt(i)));
                }
                for(int i=s.length()-1; i>n; i--){
                    list2.add(String.valueOf(s.charAt(i)));
                }
                for(int i=0; i<list.size(); i++){
                    if(!list.get(i).equals(list2.get(i))){
                        b = false;
                    }
                }


            }
            if(!b){
                System.out.println("no");
            }else{
                System.out.println("yes");
            }
        }
    }
}