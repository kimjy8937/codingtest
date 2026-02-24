import java.util.*;

class Solution {
    public int solution(String s) {
        int n = s.length();
        int answer = 0;

        for (int shift = 0; shift < n; shift++) {
            if (isValidRotation(s, shift)) answer++;
        }
        return answer;
    }

    private boolean isValidRotation(String s, int shift) {
        int n = s.length();
        ArrayDeque<Character> st = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt((shift + i) % n);

            if (ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            } else {
                if (st.isEmpty()) return false;
                char open = st.pop();
                if (!matches(open, ch)) return false;
            }
        }
        return st.isEmpty();
    }

    private boolean matches(char open, char close) {
        return (open == '(' && close == ')')
                || (open == '[' && close == ']')
                || (open == '{' && close == '}');
    }
}