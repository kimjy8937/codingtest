import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long[] dp = new long[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int n;
        for(int i = 0; i < T; i++) {
            n = Integer.parseInt(br.readLine());
            for(int j=1;j<=n;j++) {
                if(j <= 3){
                    dp[j] = 1;
                }
                if(dp[j] == 0){
                    dp[j] = dp[j-2] + dp[j-3];
                }
            }
            System.out.println(dp[n]);
        }
    }
}