import java.util.Scanner;

public class Main {
    static  int TreeNum;
    static int getTree;
    static int[] TreeLine;
    static int max;
    static  int min=0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        TreeNum = sc.nextInt();
        getTree = sc.nextInt();

        TreeLine = new int[TreeNum];
        for(int i=0; i< TreeNum; i++){
            TreeLine[i] =  sc.nextInt();
            if(max<TreeLine[i]){
                max = TreeLine[i];
            }
        }
        while (min<max){
            int mid = (min+max) /2;
            long sum = 0;
            for(int tree: TreeLine){
                if(tree-mid>0){
                    sum +=(tree-mid);
                }
            }

            if(sum<getTree){
                max = mid;
            }
            else{
                min =mid+1;
            }
        }
        System.out.println(min-1);




    }

}
