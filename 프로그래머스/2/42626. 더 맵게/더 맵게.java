import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            q.add(scoville[i]);
        }
        int k = 0;
        while (q.peek() < K) {
            if (q.size() <= 1) {
                return -1;
            }
            k = 0;
            k += q.poll();
            k += q.poll() * 2;
            answer++;
            q.add(k);
        }
        return answer;
    }
}