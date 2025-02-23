class Solution {
    public boolean solution(int x) {
        boolean answer = false;
        int sum = 0;
        for(int i = x; i > 0; i/=10){
            sum += (i % 10);
        }
        
        if(x % sum == 0)
            answer = true;
        
        return answer;
    }
}