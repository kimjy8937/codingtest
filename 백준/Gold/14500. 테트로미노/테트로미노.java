import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[][] board;
    static boolean[][] visited;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};
    static int answer;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                visited[i][j] = true;
                dfs(1, i, j, board[i][j]);
                visited[i][j] = false;
            }
        }

        System.out.println(answer);
    

    }

    public static void dfs(int count, int r, int c, int sum){
        if(count==4){
            answer = Math.max(answer, sum);
            return;
        }

        for(int i=0; i<4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr<0 || nc<0 || nr>=n || nc>=m || visited[nr][nc]) continue;

            visited[nr][nc] = true;

            if(count==2){ //ㅏ ㅓ ㅜ ㅗ. 칸 2개 선택 시 현재 위치에서 다시 탐색 시작
                dfs(count+1, r, c, sum+board[nr][nc]);
            }

            dfs(count+1, nr, nc, sum+board[nr][nc]);

            visited[nr][nc] = false;
        }

    }
}