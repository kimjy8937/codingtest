import java.util.ArrayList;
import java.util.List;
class Solution {
    public int[] solution(int n) {
        int[] answer = {};
        List<Integer> numList = new ArrayList<> ();  
        numList.add(n);
        while(n > 1){
            n = n % 2 == 0 ? n / 2 : 3 * n + 1;
            numList.add(n);
        }
        answer = numList.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}