import java.io.*;
import java.util.*;

public class Main {
    static int[][] S;
    static int N;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        S = new int[N][N];

        visited = new boolean[N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        System.out.println(min);


    }

    static void dfs(int depth, int at) {

        if(depth == N/2) {

            diff();
            return;
        }

        for(int i = at; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, i + 1);
                visited[i] = false;
            }
        }



    }


    static void diff() {
        int start_sp = 0;
        int link_sp = 0;

        for(int i = 0; i < N-1; i++) {
            for(int j = i + 1; j < N; j++) {

        
                if(visited[i] && visited[j]) {
                    start_sp += S[i][j] + S[j][i];

                }
            
                else if(!visited[i] && !visited[j]) {
                    link_sp += S[i][j] + S[j][i];

                }
            }
        }

        int res = Math.abs(start_sp - link_sp);

 
        if(res == 0) {
            System.out.println(res);
            System.exit(0);
        }

        min = Math.min(min, res);
    }
}