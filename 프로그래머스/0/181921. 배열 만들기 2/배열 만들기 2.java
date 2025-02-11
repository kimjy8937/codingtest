import java.util.ArrayList;
import java.util.List;
class Solution {
    public int[] solution(int l, int r) {
        List<Integer> result = new ArrayList<>();
        int[] intResult = {};
        while(l<=r){
            int tmp = l;
            while(true){
                if(tmp % 10 != 5 && tmp % 10 != 0){
                    break;
                }else if(tmp/10 == 0){
                    result.add(l);
                    break;
                }
                 tmp /= 10;   
            }
            l += 1;
        }
        if(result.isEmpty()) result.add(-1);
        intResult = result.stream().mapToInt(Integer::intValue).toArray();

        return intResult;
    }
}