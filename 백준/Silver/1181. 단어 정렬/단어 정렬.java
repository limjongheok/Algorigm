import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();


        for(int i=0; i<n; i++){
            set.add(br.readLine());
        }
        String[] num = new String[set.size()];

        int idx =0;
        for(String s : set){
            num[idx] = s;
            idx++;
        }



        Arrays.sort(num,(o1,o2)->{
            if(o1.toString().length() == o2.toString().length()){
                return o1.compareTo(o2);
            }else{
                return o1.toString().length() - o2.toString().length();
            }
        } );

        for(int i=0; i<num.length; i++){
            System.out.println(num[i]);
        }




    }
}