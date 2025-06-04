import java.io.*;
import java.util.*;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        Deque<int[]> deque = new ArrayDeque<>();  

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            while(!deque.isEmpty()&&deque.peekLast()[0]>num){
                deque.pollLast();
            }
            deque.add(new int[]{num, i});  
            if(deque.peekFirst()[1] == i-l) deque.pollFirst();

            int d = deque.peekFirst()[0];
            sb.append(d+" ");
        }
        System.out.println(sb);
    }
}