import java.io.*;

class Main{
    static int count = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        System.out.println(dp(n));
    }
    
    public static int dp(int n){
        if(n==1){
            count = -1;
            return count;
        }
        if(n%5 ==0){
            count += n/5;
            return count;
        }else{
            count++;
            return dp(n-2);
        }
    }
}