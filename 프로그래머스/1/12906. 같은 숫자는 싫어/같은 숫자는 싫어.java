import java.util.Stack;

public class Solution {
    public Stack<Integer> solution(int []arr) {
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i< arr.length; i++){
            if(stk.empty()){
                stk.push(arr[i]);
                continue;
            }
            if(stk.peek() == arr[i])
                continue;
            else
                stk.push(arr[i]);
        }
        return stk;
    }
}