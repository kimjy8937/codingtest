import java.io.*;
import java.util.*;

class Solution {
    static boolean[] visited = new boolean[7];
    static HashSet<Integer> hs = new HashSet<>();
    
    static void dfs(String str, String temp, int m) {
        if(temp.length() == m) {
            int num = Integer.parseInt(temp);
            hs.add(num);
        }
        for(int i = 0; i<str.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                temp += str.charAt(i);
                dfs(str, temp, m);
                visited[i] = false;
                temp = temp.substring(0, temp.length()-1);
            }
        }
        
    }
    
    static boolean isPrime(int n) {
        if(n < 2) return false;
        for(int i = 2; i*i<=n; i++) {
            if(n % i == 0) return false;
        }
        return true;
    }
    
    public int solution(String numbers) {
        int answer = 0;
        for(int i = 0; i < numbers.length(); i++){
            dfs(numbers, "", i+1);
        }
        for(Integer num : hs) {
            if(isPrime(num)){
                answer++;
            }
        }
        return answer;
    }
}