import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] queue = new int[2000000];
    static int first = 0;
    static int last = 0;

    public static void push(int x) {
        queue[last++] = x;
    }

    public static int pop() {
        if (empty() == 1) return -1;
        return queue[first++];
    }

    public static int size() {
        return last-first;
    }

    public static int front() {
        if (empty() == 1) return -1;
        return queue[first];
    }

    public static int back() {
        if (empty() == 1) return -1;
        return queue[last-1];
    }

    public static int empty() {
        if(first == last) {
            return 1;
        }else return 0;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String commandLine = br.readLine();
            StringTokenizer st = new StringTokenizer(commandLine);
            String command = st.nextToken();

            switch (command) {
                case "push":
                    int x = Integer.parseInt(st.nextToken());
                    push(x);
                    break;
                case "pop":
                    sb.append(pop()).append('\n');
                    break;
                case "size":
                    sb.append(size()).append('\n');
                    break;
                case "empty":
                    sb.append(empty()).append('\n');
                    break;
                case "front":
                    sb.append(front()).append('\n');
                    break;
                case "back":
                    sb.append(back()).append('\n');
                    break;
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
