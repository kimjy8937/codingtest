import java.util.Arrays;
import java.util.Comparator;
class Solution {
    public String solution(String s) {
        String answer = "";
        String[] strArray = s.split("");
        Arrays.sort(strArray, Comparator.reverseOrder());
        
        return String.join("", strArray);
    }
}