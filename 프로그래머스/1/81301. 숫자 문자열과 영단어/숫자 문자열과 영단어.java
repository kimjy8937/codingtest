import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(String s) {
        int answer = 0;
        HashMap<String, Integer> hs = new HashMap<>();
        
        hs.put("zero", 0);
        hs.put("one", 1);
        hs.put("two", 2);
        hs.put("three", 3);
        hs.put("four", 4);
        hs.put("five", 5);
        hs.put("six", 6);
        hs.put("seven", 7);
        hs.put("eight", 8);
        hs.put("nine", 9);
   
        
        StringBuilder sb = new StringBuilder();
        
        
        char[] ca = s.toCharArray();
        for(int i = 0; i < ca.length; i++){
            if(ca[i] >= '0' && ca[i] <= '9'){
                if(answer == 0)
                    answer += (ca[i] - '0');
                else{
                    answer *= 10;
                    answer += (ca[i] - '0');
                }
               
            }
            else {
                sb.append(ca[i]);
            }
            
            String str = sb.toString();
            if(hs.containsKey(str)){
                if(answer == 0)
                    answer += hs.get(str);
                else{
                    answer *= 10;
                    answer += hs.get(str);
                }
                sb.setLength(0);
            }
        }
        
        
        return answer;
    }
}