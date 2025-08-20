import java.io.*;
import java.util.*;

public class Main {
    static long mod = 1000000000;
    static int N;
    static long[][] dp; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new long[N + 1][10];

        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) { 

            for (int j = 0; j < 10; j++) {

                if (j == 0) {
                    dp[i][0] = dp[i - 1][1] % mod;
                } else if (j == 9) {
                    dp[i][9] = dp[i - 1][8] % mod;
                }
                else{
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod; //1~8까지는 경우가 두가지 ex)1인 경우 전 자리 수가 10 , 12 인 경우를 모두 더한다.
                }
            }
        }

        long result = 0;
        for (int i = 0; i < 10; i++) {
            result += dp[N][i];
        }
        System.out.println(result % mod);


    }
}