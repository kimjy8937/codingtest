import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    
    static int[] dx = {-1, 1, 0 ,0};
    static int[] dy = {0, 0, -1, 1};
    
    static class Node{
        int x, y, d;
        Node(int x, int y, int d){
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
    
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        visited = new boolean[N][M];
        
        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = line.charAt(j) - '0';
            }
        }
        
        System.out.print(bfs(0, 0));
    }
    
    static int bfs(int x, int y){
        Queue<Node> q = new LinkedList<>();
        visited[x][y] = true;
        q.offer(new Node(x, y, 1));
        
        while(!q.isEmpty()){
            Node now = q.poll();
            
            for(int i = 0; i < 4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                int nd = now.d + 1;
                
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(visited[nx][ny]) continue;
                if(map[nx][ny] == 0) continue;

                if(nx == N-1 && ny == M-1){
                  return nd;
                }
                
                visited[nx][ny] = true;
                q.offer(new Node(nx, ny, nd));
            }
        }
      return 0;
    }
}