import java.util.*;

class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = -1;
        
        int startSec = parseToSec(h1, m1, s1);
        int endSec = parseToSec(h2, m2, s2);
        
        answer = countAlrams(endSec) - countAlrams(startSec);
        answer += alramNow(startSec) ? 1 : 0;
        
        return answer;
    }
    
    private int parseToSec(int hour, int minute, int second) {
        return hour * 60 * 60 + minute * 60 + second;
    }
    
    private int countAlrams(int seconds) {
        int minuteAlrams = seconds * 59 / 3600;
        int hourAlrams = seconds * 719 / 43200;
        int duplicatedAlrams = 43200 <= seconds ? 2 : 1;
        
        return minuteAlrams + hourAlrams - duplicatedAlrams;
    }
    
    private boolean alramNow(int seconds) {
        return seconds * 59 / 3600 == 0 || seconds * 719 % 43200 == 0;
    }
}