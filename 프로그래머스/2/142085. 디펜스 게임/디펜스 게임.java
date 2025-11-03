import java.util.*;

class Solution {

    public int solution(int n, int k, int[] enemy) {
        
        int soldier = n;
        int passCard = k;
        
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        
        int roundIndex = 1;
        for (int round : enemy) {
            queue.add(round);
            soldier -= round;
            
            if (soldier < 0) {
                while (!queue.isEmpty()) {
                    if (passCard == 0) {
                        break;
                    }

                    soldier += queue.poll();
                    passCard--;
                    
                    if (soldier >= 0) {
                        break;
                    }
                }
            }
            
            if (soldier < 0) {
                return roundIndex - 1;
            }
            
            roundIndex++;
        }
            
        return enemy.length;
    }
}