import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        
        HashSet<Integer> hs = new HashSet<>();
        
        for(int i = 0; i<numbers.length; i++){
            hs.add(numbers[i]);
        }
        
        for(int i=0; i<=9; i++){
            if(!hs.contains(i)){
                 answer += i;
            }
               
        }
        
        return answer;
    }
}