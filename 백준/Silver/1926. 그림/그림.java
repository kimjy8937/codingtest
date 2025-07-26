import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int max = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visited;
    
    //BFS 풀이
    static int bfs(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {x, y});
        visited[x][y] = true;
        int size = 1;
        while(!q.isEmpty()){
            int[] temp = q.poll();
            int nx = temp[0];
            int ny = temp[1];
            for(int i = 0; i < 4; i++){
                int cx = nx + dx[i];
                int cy = ny + dy[i];
                
                if(cx < 0 || cy < 0 || cx > n-1 || cy > m-1) continue;
                if(visited[cx][cy]) continue;
                if(map[cx][cy] == 1){
                    size++;
                    visited[cx][cy] = true;
                    q.offer(new int[] {cx, cy});
                }
            }
        }
        return size;
    }
    
    
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
        int cnt = 0;
        
        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++) {
			 st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++){
                if(!visited[i][j] && map[i][j] == 1){
                    max = Math.max(max, bfs(i, j));
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        System.out.println(max);
    }
}