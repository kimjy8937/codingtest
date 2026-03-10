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
                    list.add(dfs(i, j));
            }
        }
        
        Collections.sort(list);
        sb.append(list.size()).append('\n');
        for(int num : list){
            sb.append(num).append('\n');
        }
        
        System.out.print(sb);
    }
    
    static int dfs(int x, int y) {
        visited[x][y] = true;
        int count = 1;
        
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if (visited[nx][ny]) continue;
            if (map[nx][ny] == 0) continue;
            
            count += dfs(nx, ny);
        }
        return count;
    }
}