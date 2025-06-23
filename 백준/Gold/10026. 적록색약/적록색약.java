import java.util.*;
import java.io.*;

public class Main{
    static int N;
    static char[][] color;
    static boolean[][] vis;
    static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { 1, 0, -1, 0 };
    
    static void bfs(int x, int y){
        Queue<int[]> que = new LinkedList<int[]>();
        que.add(new int[] { x, y });
        vis[x][y] = true;
        while(!que.isEmpty()){
            int[] temp = que.poll();
            x = temp[0];
			y = temp[1];
            for (int i = 0; i < 4; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];

				if (cx >= 0 && cy >= 0 && cx < N && cy < N) {
					if (!vis[cx][cy] && (color[cx][cy] == color[x][y])) {
						que.add(new int[] { cx, cy });
                        vis[cx][cy] = true;
					}
				}
			}
            if(color[x][y] == 'G')
                color[x][y] = 'R';
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        color = new char[N][N];
        vis = new boolean[N][N];
        int res1 = 0;
        int res2 = 0;
        
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < N; j++) {
                color[i][j] = str.charAt(j);
            }
        }
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++){
                if (!vis[i][j]) {
                    bfs(i, j);
                    res1++;
                }
            }
        }

        vis = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++){
                if (!vis[i][j]) {
                    bfs(i, j);
                    res2++;
                }
            }
        }
        sb.append(res1).append(' ').append(res2);
        System.out.println(sb.toString());
    }  
}