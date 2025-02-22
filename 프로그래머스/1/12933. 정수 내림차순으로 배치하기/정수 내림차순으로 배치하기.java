import java.util.Arrays;
import java.util.Collections;

class Solution {
    public long solution(long n) {
        long answer = 0;
        
        String[] str = Long.toString(n).split("");
        Arrays.sort(str, Collections.reverseOrder());
        
        String answ = "";
        
        for(String s : str)
           answ += s;
        
        answer = Long.parseLong(answ);
        
        return answer;
    }
}