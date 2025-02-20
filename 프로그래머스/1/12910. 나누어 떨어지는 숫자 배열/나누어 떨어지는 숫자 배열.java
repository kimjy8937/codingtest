import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
class Solution {
    public List<Integer> solution(int[] arr, int divisor) {
        List<Integer> numList = new ArrayList<>();
        for(int num : arr){
            if(num % divisor == 0){
                numList.add(num);
            }
        }
        if(numList.isEmpty())
            numList.add(-1);
        numList.sort(Comparator.naturalOrder());
        return numList;
    }
}