import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        String input = br.readLine();
        st = new StringTokenizer(input);
        while (!input.equals("0 0")) {
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a>b) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
            input = br.readLine();
            st = new StringTokenizer(input);
        }
    }
}