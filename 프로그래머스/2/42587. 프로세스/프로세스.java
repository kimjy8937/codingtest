import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pque = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        for (int i = 0; i<priorities.length; i++) {
            pque.add(priorities[i]);
        }
        while (!pque.isEmpty()) {
            for (int i = 0; i<priorities.length; i++) {
                if (priorities[i] == pque.peek()) {
                    answer++;
                    if (i == location) {
                        return answer;
                    }
                    pque.poll();
                }
            }   
        }
        
        return 0;
    }
}