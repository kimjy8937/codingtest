import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] triangle = new int[N + 1][N + 1];
        int[][] dp = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());

                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];

                if(!st.hasMoreTokens()){
                    break;
                }
            }
        }
        int max = -1;
        for(int i = 1; i <= N; i++) {
            if(max < dp[N][i])
                max = dp[N][i];
        }

        System.out.println(max);
    }
}