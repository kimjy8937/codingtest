import java.io.*;
import java.util.*;

class Solution {
    
    // 주사위 선택
    static void pickDice(int cnt, int start, int[][] dice) {
        
        if(cnt == N / 2) {
            
            int winCount = calculateWin(dice);
            
            if(max < winCount) {
                max = winCount;
                
                for(int i = 0; i < selected.size(); i++) {
                    result[i] = selected.get(i) + 1;
                }
            }
            
            return;
        }
        
        for(int i = start; i < N; i++) {
            
            selected.add(i);
            pickDice(cnt+1, i+1, dice);
            selected.remove(selected.size()-1);
        }
        
    }
    
    static int calculateWin(int[][] dice) {
        
        int count = 0;
        
        makeArrAB(dice);
        
        // arrA, arrB에 대하여 승패를 결정한다.
        
        Collections.sort(arrB);
        
        // 승부를 결정할 때, 이분 탐색을 통하여 시간복잡도를 줄인다. O(6^5 * log 6^5)
        
        for(int i = 0; i < arrA.size(); i++) {
            
            int target = arrA.get(i);
            
            int st = 0;
            int et = arrB.size() - 1;
            
            int idx = -1;
            while(st <= et) {
                
                int mid = (st + et) >> 1;
                
                if(target <= arrB.get(mid)) {
                    et = mid - 1;
                } else {
                    idx = Math.max(idx, mid);
                    st = mid + 1;
                }
                
            }
            if(idx != -1) count += idx + 1;
            
        }
        
        return count;
    }
    
    
    // 선택된 주사위들의 합 분포를 저장
    static void sumDice(int cnt, int sum, int[][] dice, List<Integer> arr) {
        
        if(cnt == N / 2) {
            arr.add(sum);
            return;
        }
        
        for(int i = 0; i < 6; i++) {
            int newSum = sum + dice[cnt][i];
            sumDice(cnt+1, newSum, dice, arr);
        }   
    }
    
    static void makeArrAB(int[][] dice) {
        
        // 선택된 주사위들의 합 분포를 저장한 배열
        arrA = new ArrayList<>();
        arrB = new ArrayList<>();
        
        int[][] diceA = new int[N / 2][6];
        int[][] diceB = new int[N / 2][6];
        
        int a = 0, b = 0;
        for(int i = 0; i < N; i++) {
            
            if(selected.contains(i)) {
                diceA[a++] = dice[i];
            } else {
                diceB[b++] = dice[i];
            }
            
        }
        
        sumDice(0, 0, diceA, arrA);
        sumDice(0, 0, diceB, arrB);
        
    }
    
    
    
    static int N, max = 0;
    static int[] result;
    static List<Integer> selected, arrA, arrB;
    public int[] solution(int[][] dice) {
        N = dice.length;
        result = new int[N / 2];
        
        selected = new ArrayList<>();
        
        pickDice(0, 0, dice);
        
        
        return result;
        
    }
}