import java.io.*;
import java.util.*;

class Main{
    private static int ask;
    private static int sAsk;
    private static int bAsk;
    private static boolean[] visited;
    private static boolean tCheck;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int tc = Integer.parseInt(br.readLine());
        int count = 0;
        visited = new boolean[1000];
        for(int t=0; t<tc; t++){
            st = new  StringTokenizer(br.readLine());
            ask = Integer.parseInt(st.nextToken());
            sAsk = Integer.parseInt(st.nextToken());
            bAsk = Integer.parseInt(st.nextToken());
            tCheck = false;
            if(t >=1) {
            	tCheck = true;
            }
       
            for(int i=1; i<=9; i++) {
            	for(int j=1; j<=9; j++) {
            		for(int z=1; z<=9; z++) {
            			if(i!=j && i!=z && j!=z) {
            				String si = Integer.toString(i);
            				String sj = Integer.toString(j);
            				String sz = Integer.toString(z);
            				
            				String sum = si+sj+sz;
            				int isum  = Integer.parseInt(sum);
            				
            				check(isum);
            			}
            		}
            	}
            }
        }
        
        
        for(int i =0; i<visited.length; i++){
            if(visited[i]){
                count ++;
            }
        }
        System.out.println(count);
    }
    private static void check(int num){
        // 현재 num이랑  제시 답이랑 비교하여 관련 숫자 check 
    	
    		
    		int strike = 0;
            int ball = 0;
            if(!tCheck) { // 처음 돌릴때
            	  for(int i=0; i<3; i++){
                      char nc = Integer.toString(num).charAt(i);
                      
                      for(int j=0; j<3; j++){
                          char ac = Integer.toString(ask).charAt(j);
                          if(nc == ac && i==j){
                              strike ++;
                          }
                          if(nc == ac && i!=j){
                              ball ++;
                          }
                      }
                  }
                  
                  if(strike == sAsk && ball == bAsk){
                      visited[num] = true; // 가능성 있음
           
                  }else{
                      visited[num] = false; // 가능성 없음
                  }
            }else { // 다음 돌릴때 
            	if(visited[num]) {// 이전에 관련 있는 애들
            		for(int i=0; i<3; i++){
                        char nc = Integer.toString(num).charAt(i);
                        
                        for(int j=0; j<3; j++){
                            char ac = Integer.toString(ask).charAt(j);
                            if(nc == ac && i==j){
                                strike ++;
                            }
                            if(nc == ac && i!=j){
                                ball ++;
                            }
                        }
                    }
                    
                    if(strike == sAsk && ball == bAsk){ 
                        visited[num] = true; // 가능성 있음
             
                    }else{
                        visited[num] = false; // 가능성 없음
                    }
            	}
            	
            	
            }
          

    }
}