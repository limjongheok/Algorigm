
import java.util.*;
import java.io.*;
public class Main {
    private static int n;

    private  static long[] array;
    private  static long[] tree;
    private static  long[] index;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        array = new long[n];
        for(int i=0; i<n; i++){
            long a = Long.parseLong(st.nextToken());
            array[i] = a;
        }
        Map<Long, Integer> map = new HashMap<>();


        for(int i=0; i<n; i++){
            map.put(array[i],i);
        }

        index = array.clone(); // 3 2 1
        Arrays.sort(index); //    1 2 3

        long count = 0;

        int treeSize = getTreeSize();
        tree = new long[treeSize+1];

        for(int i=0; i<n; i++){
            int idx = map.get(index[i]);  // 1 get 3
            count += sum(0,n-1,1,idx+1,n-1);
            update(0,n-1,1,idx,1);

        }

        System.out.println(count);


    }

    private  static int getTreeSize(){
        int h = (int)Math.ceil(Math.log(n)/Math.log(2))+1;
        return (int) Math.pow(2,h)-1;
    }

    private static  long sum(int start, int end, int nodeIdx, int leftIdx, int rightIdx){

        if (leftIdx <= start && end<=rightIdx){
            return tree[nodeIdx];
        }
        if(end<leftIdx || start> rightIdx){
            return 0;
        }
        int mid = (start+end)/2;

        return sum(start,mid,nodeIdx*2,leftIdx,rightIdx) + sum(mid+1,end,nodeIdx*2+1,leftIdx,rightIdx);

    }

    private  static  void update(int start, int end, int nodeIdx, int idx, int dif){

        if(start <= idx && end >=idx){
            tree[nodeIdx] += dif;

        }else{
            return ;
        }
        if(start == end){

            return ;
        }

        int mid = (start+end)/2;
        update(start,mid,nodeIdx*2,idx,dif);
        update(mid+1,end,nodeIdx*2+1,idx,dif);

    }
}