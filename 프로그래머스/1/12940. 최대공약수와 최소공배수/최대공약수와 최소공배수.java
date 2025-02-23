class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int maxNum = Math.max(n, m);
        int minNum = Math.min(n, m);
        
        for(int i = 1; i <= maxNum; i++){
            if(n % i == 0 && m % i == 0)
                if(answer[0] < i)
                    answer[0] = i;
        }
        
        answer[1] = minNum * (maxNum / answer[0]);
        
        return answer;
    }
}