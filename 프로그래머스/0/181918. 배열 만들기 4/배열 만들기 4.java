import java.util.Stack;

class Solution {
    public int[] solution(int[] arr) {
        int[] stk = {};
        Stack<Integer> numStk = new Stack<>();
        for(int i = 0; i < arr.length; i++){
            if(numStk.size()==0){
                numStk.push(arr[i]);
            }else if(numStk.peek() < arr[i]){
                numStk.push(arr[i]);
            }else{
                numStk.pop();
                i--;
            }
        }
        stk = numStk.stream().mapToInt(Integer::intValue).toArray();
        return stk;
    }
}