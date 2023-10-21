import java.io.*;

class Main{
    
    static long a[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        a= new long[n+1];



        for(int i=0; i<n; i++){
            a[i] = -1;
        }

        a[0]  = 1 ;
        a[1] =1;
        if(n==1){
            System.out.println(4);
        }else if(n==2){
            System.out.println(6);
        }else{
            dp(n-1);
            long sol = a[n-1] *2 + ((a[n-1]+a[n-2])*2);
            System.out.println(sol);
        }





    }
    public static long dp(int n){
        if(a[n] == -1){
            a[n] = dp(n-1) + dp(n-2);
        }

        return a[n];
    }
}