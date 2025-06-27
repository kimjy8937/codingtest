import java.util.*;
import java.io.*;

public class Main{
    static int K, W, H;
    static int result = 1;
    static boolean[][][] vis;
    static int[][] map;
    static Deque<Monkey> q;
    static int min = Integer.MAX_VALUE;
    
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    static int[] hdx = {-2, -2, -1, 1, 2, 2, -1, 1};
    static int[] hdy = {-1, 1, 2, 2, -1, 1, -2, -2};
    
    public static void bfs() {
        q = new ArrayDeque<>();
        q.offer(new Monkey(0, 0, 0, 0));
        while(!q.isEmpty()){
            Monkey temp = q.poll();
            int x = temp.x;
            int y = temp.y;
            int cnt = temp.cnt;
            int jcnt = temp.jcnt;
            
            if (x == H - 1 && y == W - 1) {
                min = Math.min(min, cnt);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= H || ny >= W) {
                    continue;
                }

                if (map[nx][ny] == 1 || vis[nx][ny][jcnt]) {
                    continue;
                }
                if (map[nx][ny] == 0) {
                    vis[nx][ny][jcnt] = true;
                    q.offer(new Monkey(nx, ny, cnt+1, jcnt));
                } 
             }
            if (jcnt < K) {
                for (int i = 0; i < 8; i++) {
                    int hx = x + hdx[i];
                    int hy = y + hdy[i];

                    if (hx < 0 || hy < 0 || hx >= H || hy >= W) {
                        continue;
                    }

                    if (map[hx][hy] == 1 || vis[hx][hy][jcnt + 1]) {
                        continue;
                    }

                    if (map[hx][hy] == 0) {
                        vis[hx][hy][jcnt + 1] = true;
                        q.offer(new Monkey(hx, hy, cnt+1, jcnt+1));
                    }
                }
            }
      
        }  
        min = -1;    
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        
        map = new int[H][W];
        vis = new boolean[H][W][K+1];
        
        for (int i = 0; i < H; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < W; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
      bfs();
      System.out.println(min);
        
    }
    static class Monkey {
        int x, y, cnt, jcnt;
        Monkey(int x, int y, int cnt, int jcnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.jcnt = jcnt;
        }
    }
}