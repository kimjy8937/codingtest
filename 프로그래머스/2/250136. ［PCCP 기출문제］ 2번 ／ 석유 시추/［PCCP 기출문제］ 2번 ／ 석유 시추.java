import java.util.*;

class Solution {
    int n, m;
    boolean[][] visited;
    int[] oilByCol;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int solution(int[][] land) {
        n = land.length;
        m = land[0].length;
        visited = new boolean[n][m];
        oilByCol = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j, land);
                }
            }
        }

        int answer = 0;
        for (int oil : oilByCol) {
            answer = Math.max(answer, oil);
        }

        return answer;
    }

    void bfs(int x, int y, int[][] land) {
        Queue<int[]> q = new ArrayDeque<>();
        Set<Integer> cols = new HashSet<>();

        q.offer(new int[]{x, y});
        visited[x][y] = true;

        int size = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            size++;
            cols.add(cy);

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (visited[nx][ny]) continue;
                if (land[nx][ny] == 0) continue;

                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});
            }
        }

        for (int col : cols) {
            oilByCol[col] += size;
        }
    }
}