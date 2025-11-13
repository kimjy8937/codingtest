import java.util.*;
class Solution {
    public int[] solution(int e, int[] starts) {
        int[] answer = new int[starts.length];
        int[] divCount = new int[e+1];
        int[] maxFreq = new int[e+1];
        int maxIdx = e;
        
        for(int i = 1; i<= e; i++)
            divCount[i] = 1;
        
        for(int i = 2; ; i++){
            if(i > e)
                break;
            for(int j = 1; ; j++){
                if(i * j > e)
                    break;
                divCount[i*j]++;
            }
        }
        
        for(int i = e; i>0; i--){
            if(divCount[i] >= divCount[maxIdx])
                maxIdx = i;
            maxFreq[i] = maxIdx;
        }
      
        
        for(int i = 0; i<answer.length; i++)
            answer[i] = maxFreq[starts[i]];
        
        return answer;
    }
}

