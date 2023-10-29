import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private  static  int n;
    private  static int m;
    private  static  int k;
    private  static  long[] tree;
    private  static  long[] arr;
    public static  void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new long[n];
        tree = new long[getTreeSize()];
        for(int i=0; i<n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        int treeSize = getTreeSize();

        tree = new long[treeSize+1];

        init(0,n-1,1); // 세그먼트 트리 초기화



        while(true) {
            StringBuffer sb = new StringBuffer();
            if(m==0 && k==0) break;

            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            if(op ==1) {
                int idx = Integer.parseInt(st.nextToken())-1;
                long num = Long.parseLong(st.nextToken());

                long dif = num - arr[idx];
                update(0, n-1, 1, idx, dif);
                arr[idx] = num;

                m--;
            }else {
                int left = Integer.parseInt(st.nextToken())-1;
                int right = Integer.parseInt(st.nextToken())-1;

                long psum =sum(0, n-1, 1, left, right);
                System.out.println(psum);

                k--;
            }
            
        }



    }

    static int getTreeSize() {
        int h = (int)Math.ceil(Math.log(n)/Math.log(2)) +1;
        return (int)Math.pow(2, h)-1;
    }

    private  static long init(int start, int end, int nodeIdx){

        if(start == end){

            return tree[nodeIdx] = arr[start];
        }

        int mid = (start + end)/2;

        return tree[nodeIdx] = init(start,mid,nodeIdx*2) + init(mid+1,end,nodeIdx*2+1);
    }

    private  static void update(int start, int end, int nodeIdx, int idx, long dif){


        // 수정할 인덱스가 시작점 과 끝점 사이에 있을시 dif를 트리에 더하기
        if(idx>=start && idx<=end){


            tree[nodeIdx] += dif;
        }else{
            return;
        }
        if(start == end){
            return ;
        }



        int mid = (start+end)/2;
        update(start,mid,nodeIdx*2,idx,dif);
        update(mid+1,end,nodeIdx*2+1,idx,dif);
    }
    static long sum(int start, int end, int node, int l, int r) {

        if(r < start || l> end ) return 0;
        if(l <= start && end <= r )return tree[node];

        int mid = (start+end)/2;

        return sum(start, mid, node*2, l, r) + sum(mid+1, end, node*2+1, l, r);
    }
}