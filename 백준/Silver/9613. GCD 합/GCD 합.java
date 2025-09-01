import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            long[] input = new long[N];
            for (int i = 0; i < N; i++) {
                input[i] = Long.parseLong(st.nextToken());
            }
            long cnt = 0;
            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    cnt += gcd(input[i], input[j]);
                }
            }
            sb.append(cnt).append("\n");
        }

        System.out.print(sb);

    }

    static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
	
}