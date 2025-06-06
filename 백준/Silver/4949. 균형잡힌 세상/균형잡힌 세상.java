import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        while(true) {
            Deque<Character> stk = new ArrayDeque<>();
            String str = br.readLine();
            if (str.equals(".")) break;
            char[] charArray = str.toCharArray();
            for(char c : charArray) {
                switch (c) {
                    case '(': case '[':
                        stk.push(c);
                        break;
                    case ')':
                        if (!stk.isEmpty() && stk.peek() == '(') {
                            stk.pop();
                            break;
                        } else {
                            stk.push(c);
                        }
                    case ']':
                        if (!stk.isEmpty() && stk.peek() == '[') {
                            stk.pop();
                            break;
                        } else {
                            stk.push(c);
                        }
                }
            }
            if (stk.isEmpty()) {
                sb.append("yes").append("\n");
            } else {
                sb.append("no").append("\n");
            }
        }
        System.out.println(sb);
    }
}
