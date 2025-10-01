import java.io.*;
import java.util.*;

public class Main {

    static boolean[] visit;
    static int[][] dp = new int[100][2];
    static List<Integer>[] list = new ArrayList[100];

    static void DFS(int current, int start){

        visit[current] = true;

        for(int next : list[current])
            if(!visit[next]) {
                dp[start][0]++; //0 : 나보다 가벼운거
                dp[next][1]++; // 1 : 나보다 무거운거
                DFS(next, start);
            }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int half = (n + 1) / 2;
        for(int i=1; i<=n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            int heavy = Integer.parseInt(st.nextToken());
            int light = Integer.parseInt(st.nextToken());

            list[heavy].add(light);
        }

        for(int i=1; i<=n; i++) {
            visit = new boolean[100];
            DFS(i, i);
        }

        int result = 0;
        for(int i=1; i<=n; i++)
            if(dp[i][0] >= half || dp[i][1] >= half)
                result++;

        System.out.println(result);
    }
}