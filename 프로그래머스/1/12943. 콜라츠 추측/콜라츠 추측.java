class Solution {
    public int solution(long num) {
        int count = 0;
        while(num != 1L){
            if(count >= 500){
                return -1;
            }
            if(num % 2L == 0)
                num /= 2L;
            else
                num = num * 3L + 1L;
            count += 1;
           
        }
        return count;
    }
}