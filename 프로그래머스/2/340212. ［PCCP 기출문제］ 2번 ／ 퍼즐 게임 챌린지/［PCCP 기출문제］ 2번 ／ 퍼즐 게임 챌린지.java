class Solution {
    public int[] diffs, times;
    public long limit;
    
    public int solution(int[] diffs, int[] times, long limit) {
        this.diffs = diffs;
        this.times = times;
        this.limit = limit;
        
        int min = 1;
        int max = 0;
        long timeSum = 0;
        for (int i=0; i<diffs.length; i++) {
            max = Math.max(max, diffs[i]);
            timeSum += times[i];
        }
        
        int mid = (min+max+1) / 2;
        System.out.println(mid);
        while (mid < max) {
            if (isPossible(mid, timeSum)) {
                max = mid;
            } else {
                min = mid;
            }
            mid = (min+max+1) / 2;
        }
        
        if (isPossible(mid-1, timeSum)) {
            return mid-1;
        } else if (isPossible(mid, timeSum)) {
            return mid;
        } return mid+1;
    }
    
    public boolean isPossible(int level, long timeSum) {
        long calc = timeSum;
        for (int i=0; i<diffs.length; i++) {
            if (diffs[i] > level) {
                int retry = diffs[i]-level;
                calc += (times[i]+times[i-1])*retry;
            }
        }
        if (calc > limit) return false;
        return true;
    }
}