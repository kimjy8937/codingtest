import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    static class Node{
        int x, y;
        Node(int x,int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        
        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < N; j++){
                map[i][j] = line.charAt(j) - '0';
            }
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == 1 && !visited[i][j])
                    list.add(bfs(i, j));
            }
        }
        
        Collections.sort(list);
        sb.append(list.size()).append('\n');
        for(int num : list){
            sb.append(num).append('\n');
        }
        
        System.out.print(sb);
    }
    
    static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        visited[x][y] = true;
        
        int count = 1;
        
        while(!q.isEmpty()){
            Node now = q.poll();
            
            for(int i = 0; i < 4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                
                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(visited[nx][ny]) continue;
                if(map[nx][ny] == 0) continue;
                
                visited[nx][ny] = true;
                q.offer(new Node(nx, ny));
                count++;
            }
        }
        return count;
    }
}