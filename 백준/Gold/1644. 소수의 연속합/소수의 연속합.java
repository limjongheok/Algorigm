import java.io.*;
import java.util.*;

class Main{
     public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        boolean[] is = new boolean[n+1];
        for(int i=0; i<is.length; i++){
            is[i] = true;
        }
        is[0] = false;
        is[1] = false;
        for(int i=2; i<=Math.sqrt(n); i++){
            if(is[i]) {
                for (int j = i * i; j <= n; j += i) {
                    is[j] = false;
                }
            }
        }

        List<Integer> list = new ArrayList();

        for(int i =0; i<is.length; i++){
            if(is[i]){
                list.add(i);
            }
        }
        if(list.size() == 0){
            System.out.println(0);
        }else{
            int start =0;
            int end = 0;
            int count = 0;
            int sum = list.get(0);
            while(start <= end){

                if(sum < n){
                    end  = end +1;
                    sum = sum + list.get(end);
                } else if (sum >=n) {
                    if(sum == n){
                        count++;
                    }
                    sum = sum - list.get(start);
                    start = start+1;
                }
                if(end == list.size()-1){
                    if(sum <n){
                        break;
                    }
                }

            }
            System.out.println(count);
        }




    }
}