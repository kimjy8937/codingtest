import java.util.*;

class Solution {    
    int[][] cost;
    int[][][] dp;
    int len;
    String nums;
   
    public int solution(String numbers) {
        int answer = 0;
        //최소한의 시간으로 타이핑을 하는 경우의 가중치 합을 return 
        
        initCost();
        
        len = numbers.length();
        nums = numbers;
        dp = new int[len][10][10]; //idx, left, right
        
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < 10; j++)
                Arrays.fill(dp[i][j], -1);
        }
        
        return solve(0, 4, 6);
    
    }
    
    public int solve(int idx, int left, int right){
        if(idx==len){
            return 0; //문자열 끝까지 탐색한 경우
        }
        //이미 계산된 경우
        if(dp[idx][left][right]!=-1) return dp[idx][left][right];
        
        int num = nums.charAt(idx) - '0';
        int ans = Integer.MAX_VALUE;
        
        //왼쪽 손가락을 움직이는 경우
        if(num!=right){
            ans = Math.min(solve(idx+1, num, right)+cost[left][num], ans);   
        }
        
        //오른쪽 손가락을 움직이는 경우
        if(num!=left){
            ans = Math.min(solve(idx+1, left, num)+cost[right][num], ans);   
        }
        
        return dp[idx][left][right] = ans;
    }
    
    public void initCost() {
	
        //0~9까지 가중치 배열 초기화
        cost = new int[10][10];
    
        int r1, c1, r2, c2;
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j<10; j++) {
                if(i==j){
                    cost[i][j] = 1;
                    continue;
                }
                
                if(i==0) {
                    r1 = 3;
                    c1 = 1;
                }
                else{
                    r1 = (i-1)/3;
                    c1 = (i-1)%3;
                }
                if(j==0) {
                    r2 = 3;
                    c2 = 1;
                }
                else{
                    r2 = (j-1)/3;
                    c2 = (j-1)%3;
                }
                
                int dr = Math.abs(r1-r2);
                int dc = Math.abs(c1-c2);
                int min = Math.min(dr, dc);
                int max = Math.max(dr, dc);
                int diff = dr+dc;
                
                if(diff==1){
                    cost[i][j] = 2;
                }
                else if(diff>1){
                    cost[i][j] = min*3 + (max-min)*2;
                }
            }
        }
    }
}