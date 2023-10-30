import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    private static  int n;
    private  static int m;
    private  static int k;
    private  static int[] arr;
    private  static long[] tree;
    private  static  int MOD;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];

        MOD=1000000007;
        int treeSize = getTreeSize();
        tree = new long[treeSize+1];



        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        treeInit(0,n-1,1);


        while(true){
            if(m==0 && k==0){
                break;
            }
            st = new StringTokenizer(br.readLine());

            int op = Integer.parseInt(st.nextToken());
            if(op==1){
                int idx = Integer.parseInt(st.nextToken())-1;
                int num =Integer.parseInt(st.nextToken());
                update(0,n-1,1,idx,num);
                m--;
            }else{
                int leftIdx = Integer.parseInt(st.nextToken())-1;
                int rightIdx = Integer.parseInt(st.nextToken())-1;

                long m = mux(0,n-1,1,leftIdx,rightIdx);


                System.out.println(m);

                k--;

            }
        }


    }

    static int getTreeSize() {
        int h = (int)Math.ceil(Math.log(n)/Math.log(2)) +1;
        return (int)Math.pow(2, h)-1;
    }

    private  static long treeInit(int start , int end , int nodeIdx){

        if(start == end){
            return tree[nodeIdx] = arr[start];
        }
        int mid = (start+end)/2;

        return tree[nodeIdx] = treeInit(start,mid,nodeIdx*2) *treeInit(mid+1,end,nodeIdx*2+1)%MOD;

    }

    private  static long update(int start, int end, int nodIdx, int idx, int dif){

        if(idx< start || idx > end ){
            return tree[nodIdx];
        }
        if(start == end){

            return tree[nodIdx] = dif ;
        }

        int mid = (start+end)/2;
        return tree[nodIdx] = update(start,mid,nodIdx*2,idx,dif) * update(mid+1,end,nodIdx*2+1,idx,dif)%MOD;
    }

    private static  long mux(int start, int end, int nodeIdx, int leftIdx, int rightIdx){

        if(leftIdx <= start && end<=rightIdx){
            return tree[nodeIdx];
        }
        if(rightIdx < start || end < leftIdx){
            return 1;
        }


        int mid = (start+end)/2;

        return mux(start,mid,nodeIdx*2,leftIdx,rightIdx) * mux(mid+1,end,nodeIdx*2+1,leftIdx,rightIdx)%MOD;
    }
}