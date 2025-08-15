import java.util.*;

class Solution {
    boolean solution(String s) {
        char[] ch = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(char c : ch) {
            if(c == '(') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}