import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new long[N + 1];


        for (int i = 1; i <= N; i++) {
            if(i == 1 || i == 2) {
                dp[i] = i;
            }
            if(dp[i] == 0){
                dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
            }
        }

        System.out.println(dp[N]);
    }
}
