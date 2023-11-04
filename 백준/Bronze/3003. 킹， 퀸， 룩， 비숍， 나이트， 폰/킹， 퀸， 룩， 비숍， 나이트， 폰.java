import java.io.*;
import java.util.*;

class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] standard = {1, 1, 2, 2, 2, 8};
        int[] arr = new int[6];
        
        for (int i=0; i<6; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i=0; i<6; i++) {
            int a = standard[i] - arr[i];
            System.out.printf(a + " ");
        }
    }
}