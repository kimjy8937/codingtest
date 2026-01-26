import java.util.*;
class Solution {
    int[][] dp;
    int[][] matrix;
    public int solution(int[][] matrix_sizes) {
        int answer = 0;
        
        matrix= matrix_sizes;
        
        int size= matrix_sizes.length;
        dp = new int[size+1][size+1];
        
        return cal(0,size);
    }
    
    public int find(int s,int e){
        if(dp[s][e]==0){
            dp[s][e]=cal(s,e);
        }
        return dp[s][e];
    }
    
    public int cal(int s,int e){
        if(e-s==1){
            return 0;
        }
        
        int as =Integer.MAX_VALUE;
        
        for(int m=s+1;m<e;m++){
            int left=find(s,m);
            int right=find(m,e);
            int current=matrix[s][0]*matrix[m][0]*matrix[e-1][1];
            as = Math.min(as,left+right+current);
        }
        return as;
    }
}