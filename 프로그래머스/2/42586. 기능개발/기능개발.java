import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        Queue<Integer> que = new ArrayDeque<>();
        Queue<Integer> speedQue = new ArrayDeque<>();
        ArrayList<Integer> list = new ArrayList();
        int day = 1;
        
        for(int i = 0; i < progresses.length; i++){
            que.offer(progresses[i]);
            speedQue.offer(speeds[i]);
        }
        
        while(!que.isEmpty()){
            int count = 0;
            while(day * speedQue.peek() + que.peek() >= 100){
                que.poll();
                speedQue.poll();
                count++;
                if(que.isEmpty()) break;
            }
            if(count > 0){
                list.add(count);
            }
            day++;
        }
        
        answer = new int[list.size()];
        
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}