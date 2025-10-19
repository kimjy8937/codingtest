import java.util.*;

class Solution {
    public String solution(long n, String[] bans) {
        String answer = "";
    
        long num;
        long[] bansNums = new long[bans.length];
        for(int i=0; i<bans.length; i++) {
            bansNums[i] = convertStrToNum(bans[i]);
        }
        
        Arrays.sort(bansNums);
        for(long bn : bansNums) if(bn <= n) n++;
        
        answer = convertNumToStr(n);
        
        return answer;
    }

    private long convertStrToNum(String str) {
        int length = str.length();
        long num = 0;

        for(int j=0;j<length;j++) {
            num += (str.charAt(j)-96) * Math.pow(26,(length-1-j));
        }

        return num;    
    }
    private String convertNumToStr(long num) {
        String str = "";

        while(num > 0) {
            str = String.valueOf((char)((num-1)%26+1+96)) + str;
            num=(num-1)/26;
        }

        return str;
    }
}