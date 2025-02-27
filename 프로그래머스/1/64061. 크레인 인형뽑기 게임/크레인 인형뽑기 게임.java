import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int score = 0;
        Stack<Integer> stk = new Stack<>();
        
        for(int i = 0; i< moves.length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[j][moves[i]-1] != 0){
                    if(stk.isEmpty()){
                        stk.push(board[j][moves[i]-1]);
                        board[j][moves[i]-1] = 0;
                        break;
                    }else if(stk.peek() == board[j][moves[i]-1]){
                        stk.pop();
                        score += 2;
                        board[j][moves[i]-1] = 0;
                        break;
                    }else{
                        stk.push(board[j][moves[i]-1]);
                        board[j][moves[i]-1] = 0;
                        break;
                    }
                }
            }
        }
        
        
        
        return score;
    }
}