import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        long total = 0;
        long sum1 = 0;
        Queue<Integer> q1 = new ArrayDeque<Integer>();
        Queue<Integer> q2 = new ArrayDeque<Integer>();
        for(int i = 0; i < queue1.length; i++) {
            total += queue1[i] + queue2[i];
            sum1 += queue1[i];
            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }
        
        if(total%2 != 0) return -1;
        long target = total/2;
        
        while(true) {
            if(answer > (queue1.length + queue2.length)*2) return -1;
            if(sum1 == target) break;
            else if(sum1 > target) {
                sum1 -= q1.peek();
                q2.add(q1.poll());
            }else {
                sum1 += q2.peek();
                q1.add(q2.poll());
            }
            answer++;
        }
        
        
        return answer;
    }
}