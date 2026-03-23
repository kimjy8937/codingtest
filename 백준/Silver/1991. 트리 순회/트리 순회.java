import java.io.*;
import java.util.*;

public class Main {
    static int[] left = new int[26];
    static int[] right = new int[26];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Arrays.fill(left, -1);
        Arrays.fill(right, -1);

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int parent = st.nextToken().charAt(0) - 'A';

            char l = st.nextToken().charAt(0);
            char r = st.nextToken().charAt(0);

            if (l != '.') left[parent] = l - 'A';
            if (r != '.') right[parent] = r - 'A';
        }

        preorder(0);
        sb.append("\n");

        inorder(0);
        sb.append("\n");

        postorder(0);

        System.out.print(sb);
    }

    static void preorder(int now) {
        sb.append((char)(now + 'A'));
        if (left[now] != -1) preorder(left[now]);
        if (right[now] != -1) preorder(right[now]);
    }

    static void inorder(int now) {
        if (left[now] != -1) inorder(left[now]);
        sb.append((char)(now + 'A'));
        if (right[now] != -1) inorder(right[now]);
    }

    static void postorder(int now) {
        if (left[now] != -1) postorder(left[now]);
        if (right[now] != -1) postorder(right[now]);
        sb.append((char)(now + 'A'));
    }
}