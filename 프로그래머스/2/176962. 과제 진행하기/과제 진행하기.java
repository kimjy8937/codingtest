import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        Plan[] planArr = new Plan[plans.length];
        int resultIdx = 0;
        
        for(int i=0; i<plans.length; i++) {
            String[] starts = plans[i][1].split(":");
            int start = Integer.parseInt(starts[0]) * 60 + Integer.parseInt(starts[1]);
            
            planArr[i] = new Plan(plans[i][0], start, Integer.parseInt(plans[i][2]));
        }
        
        Arrays.sort(planArr, (o1, o2) -> (o1.start - o2.start));
        
        Stack<Plan> stack = new Stack<>();
        stack.push(planArr[0]);
        int time = planArr[0].start;
        int planIdx = 1;
        
        while(!stack.isEmpty() || planIdx < planArr.length) {
            if(planIdx >= planArr.length) {
            	while(!stack.isEmpty()) {
            		Plan beforePlan = stack.pop();
                    time += beforePlan.playtime;
            		answer[resultIdx++] = beforePlan.name;
            	}
            	break;
            }
            
            while(!stack.isEmpty() && time + stack.peek().playtime <= planArr[planIdx].start) {
                Plan beforePlan = stack.pop();
                time += beforePlan.playtime;
                answer[resultIdx++] = beforePlan.name;
            }
            
            if(!stack.isEmpty()) {
                Plan beforePlan = stack.pop();
                beforePlan.playtime -= planArr[planIdx].start - time;
                stack.push(beforePlan);
            }
            
            time = planArr[planIdx].start;
            stack.push(planArr[planIdx++]);
        }
        
        return answer;
    }
    
    class Plan {
        String name;
        int start;
        int playtime;
        
        Plan(String name, int start, int playtime) {
            this.name = name;
            this.start = start;
            this.playtime = playtime;
        }
    }
}