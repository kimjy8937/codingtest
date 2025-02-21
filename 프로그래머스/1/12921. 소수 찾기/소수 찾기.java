class Solution {
    public int solution(int n) {
        int answer = 0;
        int isPrime;
        for(int i = 2; i <= n; i++){
            isPrime = 1;
            for(int j = 2; j < Math.sqrt(i)+1; j++){
                if(i % j == 0){
                    isPrime = 0;
                    break;
                }
            }
            if(isPrime == 1)
                answer += 1;
        }
        return answer+1;
    }
}