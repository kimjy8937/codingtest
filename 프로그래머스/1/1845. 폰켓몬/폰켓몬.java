import java.util.Set;
import java.util.HashSet;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Set<Integer> hs = new HashSet<>();
        for(int i = 0; i< nums.length; i++){
            hs.add(nums[i]);
        }

        return hs.size()>nums.length/2 ? nums.length/2 : hs.size();
    }
}