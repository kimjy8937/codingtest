import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 0; i < participant.length; i++){
            if(map.get(participant[i]) != null){
                map.put(participant[i], map.get(participant[i]) + 1);
            }else
                map.put(participant[i], 1);
        }
        
        for(int i = 0; i< completion.length; i++){
            map.put(participant[i], map.get(participant[i]) - 1);
        }
        
        for(Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue() >= 1)
                return entry.getKey();
        }
        return " ";
    }
    
}