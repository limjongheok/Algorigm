import java.io.*;

class Main{
    static boolean  b = true;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        dp(n);

        if(b){
            System.out.println("SK");
        }else{
            System.out.println("CY");
        }
    }
    public static Boolean dp(int n){

        if(n==0){
            return b;
        }

        if(n-3> 0){
            if(b){
                b =false;
            }else{
                b = true;
            }

            return dp(n-3);
        }else{
            if(b){
                b =false;
            }else{
                b = true;
            }
           return  dp(n-1);
        }

    }
}