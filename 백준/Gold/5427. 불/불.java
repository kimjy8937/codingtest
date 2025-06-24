import java.util.*;
import java.io.*;

public class Main{
    static int w, h;
    static int res;
    static char[][] building;
    static Queue<int[]> q;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    
    public static void bfs() {
        while (!q.isEmpty()) {
            res++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] temp = q.poll();
                for (int j = 0; j < 4; j++) {
                    int cx = temp[0] + dx[j];
                    int cy = temp[1] + dy[j];
                    if (cx < 0 || cx >= h || cy < 0 || cy >= w) {
                        if (building[temp[0]][temp[1]] == '@') {
                            return;
                        }
                        continue;
                    }
                    if (building[cx][cy] != '.') {
                        continue;
                    }
                    building[cx][cy] = building[temp[0]][temp[1]];
                    q.add(new int[]{cx, cy});
                }
            }
        }
        res = -1;
        return;
    }
    
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
      
        for (int tc = 0; tc < t; tc++) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            building = new char[h][w];
            q = new LinkedList<>();
            res = 0;

            int x = 0, y = 0;

            for (int i = 0; i < h; i++) {
                String str = br.readLine();
                for (int j = 0; j < w; j++) {
                    building[i][j] = str.charAt(j);
                    if (building[i][j] == '*') {
                        q.add(new int[]{i, j});
                    } else if (building[i][j] == '@') {
                        x = i;
                        y = j;
                    }
                }
            }
            q.add(new int[]{x, y});
            bfs();
            sb.append(res == -1 ?  "IMPOSSIBLE" : res).append("\n");
        }
        System.out.println(sb);
    }
}