import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int sum = 0;

        while (true) {
            if (sum >= S) {
                min = Math.min(min, right - left);
                sum -= nums[left++];
            } else {
                if (right == N) break;
                sum += nums[right++];
            }
        }

        System.out.print(min == Integer.MAX_VALUE ? 0 : min);
    }
}