import java.util.*;
import java.io.*;

public class Main {
    static int n, k;
    static final int MAX = 100000;
    static int[] time = new int[MAX + 1];

    public static void bfs() {
        Arrays.fill(time, Integer.MAX_VALUE);
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(n);
        time[n] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == k) {
                System.out.println(time[cur]);
                return;
            }

            if (cur * 2 <= MAX && time[cur * 2] > time[cur]) {
                time[cur * 2] = time[cur];
                q.offerFirst(cur * 2);
            }

            if (cur + 1 <= MAX && time[cur + 1] > time[cur] + 1) {
                time[cur + 1] = time[cur] + 1;
                q.offerLast(cur + 1);
            }

            if (cur - 1 >= 0 && time[cur - 1] > time[cur] + 1) {
                time[cur - 1] = time[cur] + 1;
                q.offerLast(cur - 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        bfs();
    }
}