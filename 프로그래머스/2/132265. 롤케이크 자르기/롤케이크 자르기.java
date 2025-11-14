import java.util.*;

class Solution {
    
    // 첫번째(왼쪽 조각) 두번째(오른쪽 조각) 그룹에서 각 토핑의 개수를 저장
    private Map<Integer, Integer> map = new HashMap<>();
    private Map<Integer, Integer> map2 = new HashMap<>();
    private int first, second;
    private int answer;
    
    public int solution(int[] topping) {
        for (int i = 0; i < topping.length; i++) {
            int Now = topping[i];
            
            // map에 없는 토핑이면 추가하고, 서로 다른 토핑 개수 first를 증가
            if (!map.containsKey(Now)) {
                map.put(Now, 1);
                first++;
            } 
            // 이미 존재하는 토핑이면 개수 증가
            else {
                map.put(Now, map.get(Now) + 1);
            }
        }
        
        // 하나씩 오른쪽 그룹 map2로 이동시키면서 두 그룹의 서로 다른 토핑 개수 비교
        for (int i = 0; i < topping.length; i++) {
            int now = topping[i];
            // 현재 토핑을 왼쪽 그룹에서 제거
            map.put(now, map.get(now) - 1);
            if (map.get(now) == 0) {
                first--;
            }
            // 현재 토핑 오른쪽 그룹에 추가
            if (!map2.containsKey(now)) {
                map2.put(now, 0);
                second++; // 새로운 종류의 토핑이므로 증가
            }
            else {
                map2.put(now, map2.get(now) + 1);
            }
            
            // 두 그룹의 서로 다른 토핑 개수가 같다면 공평하게 나눌 수 있는 경우
            // answer 증가
            if (first == second) {
                answer++;
            }
        }
        
        return answer;
    }
}