import java.util.List;
import java.util.ArrayList;
class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        int startIndex = -1;
        int endIndex = -1;
        List<Integer> numList = new ArrayList<Integer>();
        
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] == 2){
                startIndex = i;
                break;
            }
        }
        for(int j = arr.length-1; j >= 0; j--)
        {
            if(arr[j] == 2)
            {
                endIndex = j;
                break;
            }  
        }
        
        if(startIndex == -1){
            numList.add(-1);
        }else{
            for(int k = startIndex; k <= endIndex ; k++){
                numList.add(arr[k]);
            }
        }
  
        
        answer = numList.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}