import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while(!(s=br.readLine()).equals(".")){
            Stack<String> stack = new Stack();
            boolean t = true;
            for(int i=0; i<s.length(); i++){
                String c = String.valueOf(s.charAt(i));

                if(c.equals("(") || c.equals("[")){
                    stack.push(c);
                }
                if(c.equals(")") || c.equals("]")){
                    if(stack.isEmpty()){
                        t = false;
                    }else{
                        if(c.equals(")")){
                            String a = stack.pop();
                            if(!a.equals("(")){
                                t = false;
                            }
                        }
                        if(c.equals("]")){
                            String a = stack.pop();
                            if(!a.equals("[")){
                                t = false;
                            }
                        }
                    }

                }


            }
            if(!stack.isEmpty()){
                System.out.println("no");
            }else{
                if(!t){
                    System.out.println("no");
                }else{
                    System.out.println("yes");
                }
            }

        }
    }
}