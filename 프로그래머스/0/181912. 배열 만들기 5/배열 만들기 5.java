import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> solution(String[] intStrs, int k, int s, int l) {
        List<Integer> answer = new ArrayList<Integer>();
        
        for(String intStr : intStrs){
            if(Integer.parseInt(intStr.substring(s, s+l)) > k){
                answer.add(Integer.parseInt(intStr.substring(s, s+l)));
            }
        }
        
        return answer;
    }
}