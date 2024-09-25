import java.util.*;

class Solution {
    public int[][] land;
    public boolean[][] visit;
    public HashMap<Integer, Integer> oilMap = new HashMap<>();
    public HashMap<Integer, HashSet<Integer>> sichMap = new HashMap<>();
    
    public int[] dx = {-1, 1, 0, 0};
    public int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] land) {
        this.land = land;
        visit = new boolean[land.length][land[0].length];
        for (int i=0; i<land[0].length; i++) {
            sichMap.put(i, new HashSet<>());
        }
        
        int oilNum = 1;
        for (int i=0; i<land.length; i++) {
            for (int j=0; j<land[0].length; j++) {
                if (land[i][j]==1 && !visit[i][j]) {
                    int oil = dfs(i, j, oilNum);
                    oilMap.put(oilNum, oil);
                    oilNum++;
                }
            }
        }
        
        int max = 0;
        for (int i=0; i<land[0].length; i++) {
            int sum = 0;
            for (int set : sichMap.get(i)) {
                sum += oilMap.get(set);
            }
            max = Math.max(max, sum);
        }
        return max;
    }
    
    public int dfs(int x, int y, int oilNum) {
        visit[x][y] = true;
        Queue<Dot> q = new LinkedList<>();
        q.add(new Dot(x, y));
        HashSet<Integer> tmp = sichMap.get(y);
        tmp.add(oilNum);
        sichMap.put(y, tmp);
        
        int oil = 1;
        while (!q.isEmpty()) {
            Dot now = q.poll();
            for (int i=0; i<4; i++) {
                int nx = now.x+dx[i];
                int ny = now.y+dy[i];
                if (nx<0 || ny<0 || nx>=land.length || ny>=land[0].length) continue;
                if (visit[nx][ny]) continue;
                if (land[nx][ny] == 0) continue;
                q.add(new Dot(nx, ny));
                visit[nx][ny] = true;
                oil++;
                tmp = sichMap.get(ny);
                tmp.add(oilNum);
                sichMap.put(ny, tmp);
            }
        }
        return oil;
    }
    
    class Dot {
        int x, y;
        Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}