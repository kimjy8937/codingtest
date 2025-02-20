import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> numList = new ArrayList<>();
        for(int num : arr){
            if(num % divisor == 0){
                numList.add(num);
            }
        }
        if(numList.isEmpty())
            numList.add(-1);
        numList.sort(Comparator.naturalOrder());
        
        int[] answer = new int[numList.size()];
        for(int i = 0; i<numList.size(); i++){
            answer[i] = numList.get(i);
        }
        
        return answer;
    }
}