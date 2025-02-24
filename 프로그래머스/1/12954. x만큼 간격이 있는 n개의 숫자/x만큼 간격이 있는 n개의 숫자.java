class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        long xLong = x;
        
        for(int i = 0; i < n; i++){
            answer[i] = xLong + (long)(i * xLong);
        }
        
        return answer;
    }
}