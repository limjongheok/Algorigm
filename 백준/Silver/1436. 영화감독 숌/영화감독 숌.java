import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int count = 0;
        int i =665;
        while(count !=n){
            i++;
            if(String.valueOf(i).contains("666")){
                count++;
            }
            
        }
        System.out.println(i);
        
    }
}