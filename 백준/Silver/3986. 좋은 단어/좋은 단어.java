import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;


        for(int i = 0; i < N; i++) {
            Deque<Character> stk = new ArrayDeque<>();
            String str = br.readLine();
            char[] charArray = str.toCharArray();

            for(char c : charArray) {
                switch (c) {
                    case 'A':
                        if(!stk.isEmpty() && stk.peek() == 'A') {
                            stk.pop();
                        } else {
                            stk.push(c);
                        }
                        break;
                    case 'B':
                        if(!stk.isEmpty() && stk.peek() == 'B') {
                            stk.pop();
                        } else {
                            stk.push(c);
                        }
                        break;
                }
            }
            if (stk.isEmpty()) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}