import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {  
        Map<Integer, Integer> attackInfo = new HashMap<>();
        int curHealth = health;
        int successTime = 0;
             
        // Map에 저장하여 key와 value로 조회 
        for (int[] attack : attacks) {
            attackInfo.put(attack[0], attack[1]);
        }

        for (int i = 1; i <= attacks[attacks.length-1][0]; i++) {
            // 공격이 있다면
            if (attackInfo.containsKey(i)) { 
                curHealth -= attackInfo.get(i);
                successTime = 0;
            } 
            // 공격이 없다면
            else { 
                curHealth += bandage[1];
                successTime++;
                if (successTime == bandage[0]) {
                    curHealth += bandage[2];
                    successTime = 0;
                }
                if (curHealth > health) {
                    curHealth = health;
                }
            }
            if (curHealth <= 0) { 
                return -1;
            }
        }
        return curHealth;
    }
}