import java.util.*;
import java.io.*;

public class Main {
    static int[] deque = new int[10001];
    static int first = 5000;
    static int last = 5000;

    public static void push_front(int x) {
        deque[--first] = x;
    }

    public static void push_back(int x) {
        deque[last++] = x;
    }

    public static int pop_front() {
        if (empty() == 1) return -1;
        return deque[first++];
    }

    public static int pop_back() {
        if (empty() == 1) return -1;
        return deque[--last];
    }

    public static int size() {
        return last - first;
    }

    public static int empty() {
        return (last == first) ? 1 : 0;
    }

    public static int front() {
        if (empty() == 1) return -1;
        return deque[first];
    }

    public static int back() {
        if (empty() == 1) return -1;
        return deque[last - 1];
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
                case "push_front":
                    push_front(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    push_back(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    sb.append(pop_front()).append('\n');
                    break;
                case "pop_back":
                    sb.append(pop_back()).append('\n');
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
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}