import java.util.*;
import java.io.*;

public class Main{
    static int T, I;
    static int x1, x2, y1, y2;
    static int[][] board;
    static boolean[][] vis;
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};
    
    public static void bfs() {
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x1, y1});
        vis[x1][y1] = true;
        
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int nx = temp[0];
            int ny = temp[1];
            
            for(int i = 0; i < 8; i++){
                int cx = nx + dx[i];
                int cy = ny + dy[i];
                
                if (cx >= 0 && cy >= 0 && cx < I && cy < I){
                    if (!vis[cx][cy]){
                        q.add(new int[]{cx, cy});
                        board[cx][cy] = board[nx][ny] + 1;
                        vis[cx][cy] = true;
                    }
                }
            }
        }
    }
    
    
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < T; i++){
            I = Integer.parseInt(br.readLine());
            
            board = new int[I][I];
            vis = new boolean[I][I];
            
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            
            bfs();
            sb.append(board[x2][y2]).append("\n");
        }
        System.out.println(sb);
    }
}