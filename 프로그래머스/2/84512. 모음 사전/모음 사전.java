import java.util.*;
import java.io.*;

class Solution {
    static char[] alphabets = new char[] {'A', 'E', 'I', 'O', 'U'};
    static ArrayList<String> list;
    
    static void dfs(String res) {
        list.add(res);
        if(res.length() == 5) {
            return;
        }
        for(int i = 0; i < 5; i++){
            dfs(res + alphabets[i]);
        }
        return;
    }
    
    public int solution(String word) {
        int answer = 0;
        list = new ArrayList<>();
        dfs("");
        
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).equals(word)){
                answer = i;
            }
        }
        return answer;
    }
}
