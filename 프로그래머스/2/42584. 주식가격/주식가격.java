import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < prices.length; i++) {
            queue.offer(prices[i]);
        }

        int idx = 0;
        while (!queue.isEmpty()) {
            int item = queue.poll();
            for (int i = (prices.length - queue.size()); i < prices.length; i++) {

                if (item > prices[i]) { 
                    answer[idx]++;
                    break;
                } else if (item <= prices[i]) {
                    answer[idx]++;
                }
            }
            idx++;
        }
        return answer;
    }
}