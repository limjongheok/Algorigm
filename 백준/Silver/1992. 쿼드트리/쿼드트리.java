import java.io.*;
import java.util.*;

class Main{
     private static int[][] arr;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }

        checkArr(n,0,0);
        System.out.println(sb);
    }

    private static void checkArr(int size, int x, int y){
        if(size == 1){
            sb.append(arr[x][y]);
            return;
        }
        int start = arr[x][y];
        boolean check = true;
        for(int i=x; i<x+size; i++){
            for(int j=y; j<y+size; j++){

                if(arr[i][j]!= start){
                    check = false;
                }
            }
        }

        if(!check){
            size = size/2;
            sb.append("(");
            checkArr(size, x , y); // 왼
            checkArr(size , x , y+size ); //오
            checkArr(size , x+size,y); //
            checkArr(size,x+size,y+size);
            sb.append(")");
        }else{
            sb.append(start);
        }




    }
}