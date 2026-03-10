import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] map;
    static boolean[][] visited;
    static int N, M;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    static class Node{
        int x, y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        
        int nx = 0;
        int ny = 0;
        
        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = line.charAt(j);
                if(line.charAt(j) == 'I'){
                    nx = i;
                    ny = j;
                }
            }
        }
        int answer = bfs(nx, ny);
        if(answer == 0){
          System.out.print("TT");
        }else {
          System.out.print(answer);
        }       
    }
    
    static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        int count = 0;
        q.offer(new Node(x, y));
        visited[x][y] = true;

        while(!q.isEmpty()){
          Node now = q.poll();
          for(int i = 0; i < 4; i++){
            int nx = now.x + dx[i];
            int ny = now.y + dy[i];
            if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if(visited[nx][ny]) continue;
            if(map[nx][ny] == 'X') continue;
            
            q.offer(new Node(nx, ny));
            if(map[nx][ny] == 'P'){
                count++;
            }
            visited[nx][ny] = true;
          }
        }
        
        return count;
    }
}