import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int S = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            int num = 0;

            if (st.hasMoreTokens()) {
                num = Integer.parseInt(st.nextToken());
            }

            switch (op) {
                case "add":
                    S |= (1 << num);
                    break;
                case "remove":
                    S &= ~(1 << num);
                    break;
                case "check":
                    sb.append((S & (1 << num)) != 0 ? 1 : 0).append('\n');
                    break;
                case "toggle":
                    S ^= (1 << num);
                    break;
                case "all":
                    S = (1 << 21) - 1;
                    break;
                case "empty":
                    S = 0;
                    break;
            }
        }

        System.out.print(sb);
    }
}