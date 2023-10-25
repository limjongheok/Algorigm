import java.io.*;
import java.util.*;

class Main{
public static void main(String[] args) throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        double w = Double.parseDouble(st.nextToken());
        double h = Double.parseDouble(st.nextToken());

        double s = w*h/2;
        System.out.printf("%.1f",s);


    }
}