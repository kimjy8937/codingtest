import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : participant) {
            map.merge(s, 1, Integer::sum);
        }

        for(int i = 0; i< completion.length; i++){
            map.put(completion[i], map.get(completion[i]) - 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() > 0){
                return entry.getKey();
            }
        }
        
        return " ";
    }
}