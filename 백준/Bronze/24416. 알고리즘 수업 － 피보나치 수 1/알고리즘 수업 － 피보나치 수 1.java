import java.io.*;

class Main{
    static int[] f;
    static int fibn = 0;
    static int fibon = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        f = new int[n+1];

        fib(n);
        fibo(n);

        System.out.println(fibn +" " +fibon);
    }
    public static int fib(int n){

        if(n==1){
            fibn++;
            return 1;
        }
        if(n==2){
            fibn++;
            return 2;
        }


        return (fib(n-1) + fib(n-2));
    }

    public static int fibo(int n){
        if(n==1){
            f[1] = 1;

        }
        if(n==2){
            f[2] = 1;
        }

        for(int i=3; i<=n; i++){
            fibon++;
            f[i] = f[i-1] + f[i-2];
        }

        return f[n];

    }
    
}