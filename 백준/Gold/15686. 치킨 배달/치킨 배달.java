import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static int n, m;
    static int 전체치킨집수;
    static int min = Integer.MAX_VALUE;

    static List<Node> 집목록;
    static List<Node> 치킨집목록;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        집목록 = new ArrayList<>();
        치킨집목록 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    집목록.add(new Node(i, j));
                } else if (map[i][j] == 2) {
                    치킨집목록.add(new Node(i, j));
                }
            }
        }

        전체치킨집수 = 치킨집목록.size();
        boolean[] visited = new boolean[전체치킨집수];

        치킨집뽑기(0, 0, visited);
        System.out.println(min);
    }

    private static void 치킨집뽑기(int count, int 시작지점, boolean[] visited) {
        if (count == m) {
            계산하고최소값업데이트(visited);
            return;
        }

        for (int i = 시작지점; i < 전체치킨집수; i++) {
            if (!visited[i]) {
                visited[i] = true;
                치킨집뽑기(count + 1, i + 1, visited);
                visited[i] = false;
            }
        }
    }

    private static void 계산하고최소값업데이트(boolean[] visited) {
        int sum = 0;

        for (Node 집 : 집목록) {
            int 최소거리 = Integer.MAX_VALUE;
            for (int i = 0; i < 전체치킨집수; i++) {
                if (visited[i]) {
                    Node 치킨집 = 치킨집목록.get(i);
                    최소거리 = Math.min(최소거리, Math.abs(집.x - 치킨집.x) + Math.abs(집.y - 치킨집.y));
                }
            }
            sum += 최소거리;

            // 이미 현재 계산 중인 치킨 거리 합이 최소값보다 크면 중단
            if (sum >= min) {
                return;
            }
        }

        min = Math.min(min, sum);
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}