import java.io.*;
import java.util.*;

public class Main {

    private static int[] T, P;
    private static int N;
    private static int max;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(in.readLine());

        T = new int[N + 2];
        P = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N + 2];
        for (int i = 1; i < N + 2; i++) {
            if (max < dp[i])
                max = dp[i];

            int day = i + T[i];
            if (day < N + 2)
                dp[day] = Math.max(dp[day], max + P[i]);
        }

        System.out.println(max);
    }
}