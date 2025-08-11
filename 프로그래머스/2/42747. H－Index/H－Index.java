import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int[] reverse = new int[citations.length + 1];
        Arrays.sort(citations);
        for(int i = 1; i < reverse.length; i++){
            reverse[i] = citations[reverse.length-i-1];
        }
        
        for(int i = 1; i < reverse.length; i++){
            if(reverse[i] >= i){
                answer = i;
            }else {
                break;
            }
        }
        return answer;
    }
}