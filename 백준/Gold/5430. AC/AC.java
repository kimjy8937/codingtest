import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int loof = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < loof; i++) {

            String command = br.readLine();
            String temp = br.readLine();
            String list = br.readLine().replaceAll("[\\[\\]]", "");

         
            Deque<Integer> que = new ArrayDeque<>();

            if (!list.isEmpty()) { 
                String[] numbers = list.split(",");
                for (String num : numbers) {
                    que.add(Integer.parseInt(num));
                }
            }

            boolean reverse = false;
            boolean error = false;

            for (char c : command.toCharArray()) {
                if (c == 'R') {
                    reverse = !reverse; 
                } else if (c == 'D') {
                    if (que.isEmpty()) { 
                        error = true;
                        break;
                    }
                    if (reverse) {
                        que.pollLast(); 
                    } else {
                        que.pollFirst(); 
                    }
                }
            }

            if (error) {
                sb.append("error\n");
            } else {
                sb.append("[");
                while (!que.isEmpty()) {
                    sb.append(reverse ? que.pollLast() : que.pollFirst());
                    if (!que.isEmpty()) {
                        sb.append(",");
                    }
                }
                sb.append("]\n");
            }
        }

        System.out.print(sb.toString()); 
    }
}