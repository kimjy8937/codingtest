import java.util.Map;
import java.util.HashMap;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int count = 0;
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int i = 0; i< nums.length; i++){
            if(hm.get(nums[i]) == null){
                hm.put(nums[i], 1);
                count += 1;
            }else{
                hm.put(nums[i], hm.get(nums[i]) + 1);
            }            
        }
        
        if(count <= nums.length/2)
            answer =  count;
        else 
            answer = nums.length / 2;
        
        return answer;
    }
}