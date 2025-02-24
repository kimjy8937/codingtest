import java.util.Arrays;
class Solution {
    public int[] solution(int[] arr) {
        int[] answer = new int[arr.length-1];
        int minNum = Integer.MAX_VALUE;
        int minNumIndex = 0;
        
        for(int i = 0; i < arr.length; i++){
            if(minNum > arr[i]){
                minNum = arr[i];
                minNumIndex = i;
            }
                
        }
        for(int i = 0; i < arr.length-1; i++){
            if(i < minNumIndex)
                answer[i] = arr[i];
            else
                answer[i] = arr[i+1];
        }
        
        if(answer.length == 0){
            answer = new int[]{-1};
        }
            
         
        
        return answer;
    }
}