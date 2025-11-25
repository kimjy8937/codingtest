class Solution {
    public long solution(long k, long d) {
        long answer = 0;

        for(long x = 0; x <= d; x += k){
            long maxY = (long) Math.sqrt(d*d - x*x); 
            answer += maxY / k + 1;
        }
        
        return answer;
    }
}