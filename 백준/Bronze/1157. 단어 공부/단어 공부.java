import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s= br.readLine();
        s = s.toUpperCase();

        char[] al = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        int[] n = new int[26];

        for(int i=0; i<s.length(); i++){

            for(int j=0; j<26; j++){
                if(al[j] == s.charAt(i)){
                    n[j]=1+n[j];
                }
            }
        }

        int max = n[0];
        int c =0;

        for(int i=0; i<26; i++){
            if(max<n[i]){
                max = n[i];
                c = i;
            }
        }

        int count = 0;
        for(int i=0; i<26; i++){
            if(n[i] == max){
                count ++;
            }
        }

        if(count ==1){
            System.out.println(al[c]);
        }else{
            System.out.println("?");
        }


    }
}