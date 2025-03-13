import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] dp = new int[N + 1];
            
            
            dp[1] = 1;
            if(N >= 2) dp[2] = 2;
            if(N >= 3) dp[3] = 4;

            for(int j = 4; j <= N; j++) {
                dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];
            }

            System.out.println(dp[N]);
        }
    }
}
