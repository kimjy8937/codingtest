import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] strings = new String[numbers.length];
        
        for(int i = 0; i < numbers.length; i++){
            strings[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(strings, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        if(strings[0].equals("0")){
            return "0";
        }
        
        for(int i = 0; i < strings.length; i++){
            answer += strings[i];
        }
        
        return answer;
    }
}