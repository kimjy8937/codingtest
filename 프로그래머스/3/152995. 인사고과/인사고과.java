import java.util.*;
class Solution {
    public int solution(int[][] scores) {
        int score1 = scores[0][0]; // 완호 근무 태도 점수 
        int score2 = scores[0][1]; // 완호 동료 평가 점수 
        int sum = score1 + score2; // 완호 종합 점수 
        int cnt = 1;               // 완호 등수 
        
        // 근무 태도 점수 내림차순 / 동료 평가 점수 오름차순 
        Arrays.sort(scores, (o1,o2)->{  
           if(o1[0] != o2[0]) return o2[0] - o1[0];
           return o1[1] - o2[1];
        });
        
        int max = scores[0][1]; // 동료 평가 점수 
        int cur = scores[0][0]; // 근무 태도 점수
        
        TreeSet<Integer> ts = new TreeSet<>(); // 근무 태도 점수가 더 큰 (동료 평가 점수 모음집)
        Set<Integer> temp = new HashSet<>(); // ts 갱신용 
        temp.add(scores[0][1]);
        
        for(int i = 0; i < scores.length; i++){
            boolean safe = true;
            if(cur > scores[i][0]){ // 앞에 케이스 전부가 근무 태도 점수가 더 큰 상황 
                if(max > scores[i][1]) safe = false;
                for(int next : temp){ // ts 갱신
                    ts.add(next);
                }
                temp.clear();
            }
            else if(cur == scores[i][0]){
                temp.add(scores[i][1]);
                Integer result = ts.higher(scores[i][1]); // 근무 태도 점수가 더 큰 동료 점수 모음집 서치 
                if(result != null){
                    safe = false;
                }
            }
            max = Math.max(max, scores[i][1]); // max 항상 갱신 
            
            if(!safe && scores[i][0] == score1 && scores[i][1] == score2) return -1;
            if(safe && sum < scores[i][0] + scores[i][1]) cnt++;
        }
        
        return cnt;
    }
}