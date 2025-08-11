import java.util.*;
import java.io.*;

public class Main {
    static int count, N, M;
    static int[][] room;
    static boolean[][] visited;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {-1, 0, 1, 0};
    
    static void dfs(int x, int y, int d) {
        if (!visited[x][y]) {
            visited[x][y] = true;
            count++;
        }
        boolean flag = false;
        
        for(int i = 0; i < 4; i++){
            int dir = (d - i - 1) < 0 ? (d - i + 3) : d - i - 1;
            
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            
            if (!visited[nx][ny] && room[nx][ny] == 0) {
                flag = true;
                dfs(nx, ny, dir);
                return;
            }
        }
        if(flag == false){
            int bx = x - dx[d];
            int by = y - dy[d];
            if (bx < 0 || bx >= N || by < 0 || by >= M || room[bx][by] == 1) return;

            dfs(bx, by, d);
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        room = new int[N][M];
        visited = new boolean[N][M];
        
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dfs(x, y, d);
        System.out.println(count);
    }
}