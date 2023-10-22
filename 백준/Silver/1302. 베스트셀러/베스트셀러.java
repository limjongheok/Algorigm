import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Map<String,Integer> map = new HashMap();
        for(int i = 0; i<n; i++){
            String s = br.readLine();

            if(map.containsKey(s)){
                map.replace(s, map.get(s)+1);
            }else{
                map.put(s,1);
            }
        }


        String maxs= " ";
        int max = 0;

        for(String key : map.keySet()){


            if(max < map.get(key)){
                max = map.get(key);
            }
        }

        List<String> list = new ArrayList();
        for(String key : map.keySet()){

            if(max == map.get(key)){
                list.add(key);
            }

        }

        Collections.sort(list);
        System.out.println(list.get(0));




    }
}