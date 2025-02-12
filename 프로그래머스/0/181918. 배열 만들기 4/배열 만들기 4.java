import java.util.ArrayDeque;

class Solution {
    public int[] solution(int[] arr) {
        int[] stk = {};
        ArrayDeque<Integer> numStk = new ArrayDeque<>();
        for(int i = 0; i < arr.length; i++){
            if(numStk.size()==0){
                numStk.addLast(arr[i]);
            }else if(numStk.peekLast() < arr[i]){
                numStk.addLast(arr[i]);
            }else{
                numStk.removeLast();
                i--;
            }
        }
        stk = numStk.stream().mapToInt(Integer::intValue).toArray();
        return stk;
    }
}