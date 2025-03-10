import java.util.Set;
import java.util.HashSet;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int[] rank = new int[] {6,6,5,4,3,2,1};
        HashSet<Integer> hs = new HashSet<>();
        for(int num : win_nums){
            hs.add(num);
        }
        
        int zeroCount = 0;
        for(int i = 0; i < lottos.length; i++){
            if(lottos[i] == 0){
                zeroCount++;
            }else if(hs.contains(lottos[i])){
                answer[1]++;
            } 
        }
    
        answer[0] = answer[1] + zeroCount;
        answer[0] = rank[answer[0]];
        answer[1] = rank[answer[1]];
        return answer;
    }
}