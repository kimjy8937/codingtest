import java.util.*;
import java.io.*;

public class Main{
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0, 0});
        visited[0][0] = true;
        
        while(!q.isEmpty()){
            int[] temp = q.poll();
            int nx = temp[0];
            int ny = temp[1];
            for(int i = 0; i < 4; i++){
                int cx = nx + dx[i];
                int cy = ny + dy[i];
                
                if(cx < 0 || cy < 0 || cx > n - 1 || cy > m - 1) continue;
                if(visited[cx][cy] || map[cx][cy] == 0) continue;
                
                q.offer(new int[] {cx, cy});
                map[cx][cy] = map[nx][ny] + 1;
                visited[cx][cy] = true;
            }
        }
    }
    
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        map = new int[n][m];
        visited = new boolean[n][m];
        
        for(int i = 0; i < n; i++){
            String line = br.readLine();
            for(int j = 0; j < m; j++){
                map[i][j] = line.charAt(j) - '0';
            }
        }
        bfs();
        System.out.println(map[n-1][m-1]);
    }
}