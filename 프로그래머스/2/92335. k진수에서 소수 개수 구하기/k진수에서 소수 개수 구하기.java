import java.math.*;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            sb.append(n % k);
            n /= k;
        }
        
        for(String s : sb.reverse().toString().split("0")) {
            if(s.isEmpty()) continue;
            BigInteger num = new BigInteger(s);
            if(num.isProbablePrime(5))
                answer++;
        }
        return answer;
    }
}