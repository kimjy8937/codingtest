import java.util.*;

class Solution {

    static class State implements Comparable<State> {
        int r, c, dir, cost; // dir: 0=U,1=R,2=D,3=L, -1=start
        State(int r, int c, int dir, int cost) {
            this.r = r; this.c = c; this.dir = dir; this.cost = cost;
        }
        public int compareTo(State o) {
            return this.cost - o.cost;
        }
    }

    public int solution(int[][] board) {
        int n = board.length;
        int INF = 1_000_000_000;

        int[][][] dist = new int[n][n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) Arrays.fill(dist[i][j], INF);
        }

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        PriorityQueue<State> pq = new PriorityQueue<>();

        // 시작점에서 첫 이동은 방향/코너 개념이 없으므로, 가능한 방향으로 "시작"을 확장
        for (int d = 0; d < 4; d++) {
            int nr = 0 + dr[d], nc = 0 + dc[d];
            if (nr < 0 || nc < 0 || nr >= n || nc >= n) continue;
            if (board[nr][nc] == 1) continue;
            dist[nr][nc][d] = 100;
            pq.offer(new State(nr, nc, d, 100));
        }

        while (!pq.isEmpty()) {
            State cur = pq.poll();
            if (cur.cost != dist[cur.r][cur.c][cur.dir]) continue;

            for (int nd = 0; nd < 4; nd++) {
                int nr = cur.r + dr[nd];
                int nc = cur.c + dc[nd];
                if (nr < 0 || nc < 0 || nr >= n || nc >= n) continue;
                if (board[nr][nc] == 1) continue;

                int add = (nd == cur.dir) ? 100 : 600; // 직선 100, 코너면 +500 => 600
                int ncost = cur.cost + add;

                if (dist[nr][nc][nd] > ncost) {
                    dist[nr][nc][nd] = ncost;
                    pq.offer(new State(nr, nc, nd, ncost));
                }
            }
        }

        int ans = INF;
        for (int d = 0; d < 4; d++) ans = Math.min(ans, dist[n - 1][n - 1][d]);
        return ans;
    }
}