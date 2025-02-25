import java.util.HashMap;
import java.util.Arrays;
import java.util.Map;

class Solution {
    public boolean solution(String[] phone_book) {
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i = 0; i<phone_book.length; i++){
            hm.put(phone_book[i], i);
        }
        
        for(int i = 0; i<phone_book.length; i++){
            for(int j = 0; j<phone_book[i].length(); j++){
                if(hm.containsKey(phone_book[i].substring(0, j)))
                    return false;
            }
        }
     
        return true;
    }
}