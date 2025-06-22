import java.util.*;
import java.io.*;

public class Main{
    static int M, N, K;
	static int[][] cabbage;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { 1, 0, -1, 0 };
    
    static void bfs(int x, int y){
        Queue<int[]> que = new LinkedList<int[]>();
        que.add(new int[] { x, y });
        cabbage[x][y] = 0;
        while(!que.isEmpty()){
            int[] temp = que.poll();
            x = temp[0];
			y = temp[1];
            for (int i = 0; i < 4; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];

				if (cx >= 0 && cy >= 0 && cx < M && cy < N) {
					if (cabbage[cx][cy] == 1) {
						que.add(new int[] { cx, cy });
						cabbage[cx][cy] = 0;
					}
				}
			}
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
 
        
        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            cabbage = new int[M][N];
			int count = 0;
            
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
				int nx = Integer.parseInt(st.nextToken());
				int ny = Integer.parseInt(st.nextToken());
				cabbage[nx][ny] = 1;
			}
            
            for (int j = 0; j < M; j++) {
				for (int k = 0; k < N; k++) {
					if (cabbage[j][k] == 1) {
						bfs(j, k);
						count++;
					}
				}
			}
            System.out.println(count);
        }      
    }
}