import java.util.Arrays;
class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];
        Arrays.fill(answer, 0);
        for(int i = 0; i<my_string.length(); i++){
            if(64 < my_string.charAt(i) && 91 > my_string.charAt(i))
                answer[my_string.charAt(i)-65] += 1;
            else if(96 < my_string.charAt(i) && 123 > my_string.charAt(i))
                answer[my_string.charAt(i)-97+26] += 1;
        }
        
        
        return answer;
    }
}