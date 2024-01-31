import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
     public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;


        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n+1];
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());

        for(int i=0; i<m; i++){
            st =new StringTokenizer(br.readLine());
            int gen = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if(gen == 1){//배수 바꾸기

                for(int j=num; j<arr.length; j+=num ){
                    if(arr[j]==1){
                        arr[j] = 0;
                    }else{
                        arr[j] =1;
                    }
                }

            }else{
                int start = num;
                int end = num;

                while (arr[start] == arr[end]){ // 시작 끝을 줄이며 대칭 비교


                    if(arr[start] ==1 ){
                        arr[start] = 0;
                        arr[end] = 0;
                    }else{
                        arr[start] = 1;
                        arr[end] = 1;
                    }
                    start= start -1;
                    end = end+1;

                    if(start == 0){
                        break;
                    }
                    if(end == arr.length){
                        break;
                    }


                }

            }

        }
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<arr.length; i++){
            sb.append(arr[i]+ " ");
            if(i%20==0){
                sb.append("\n");
            }
        }
        System.out.print(sb);

    }
}