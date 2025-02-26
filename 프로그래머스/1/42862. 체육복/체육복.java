import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        Arrays.sort(reserve);

        for(int i = 0; i < lost.length; i++){
            hm.put(lost[i], 1);
        }
        
        
        for(int i = 0; i < reserve.length; i++){
            if(hm.containsKey(reserve[i])){
                hm.remove(reserve[i]);
                reserve[i] = -1;
            }
        }
        
        for(int i = 0; i < reserve.length; i++)
        {
            if(hm.containsKey(reserve[i]-1)){
                hm.remove(reserve[i]-1);
            }else if(hm.containsKey(reserve[i]+1)){
                hm.remove(reserve[i]+1);
            }   
        }
        
        answer -= hm.size();
        return answer;
    }
}