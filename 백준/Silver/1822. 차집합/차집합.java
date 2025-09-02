import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nA = Integer.parseInt(st.nextToken());
        int nB = Integer.parseInt(st.nextToken());

        TreeSet<Integer> groupA = new TreeSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nA; i++) {
            groupA.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nB; i++) {
            int num = Integer.parseInt(st.nextToken());
            groupA.remove(num);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(groupA.size() + "\n");
        for (Integer i : groupA) {
            sb.append(i + " ");
        }
        System.out.println(sb);
    }
}