class Solution {
    static String reverseStr(String str, int start, int end){
        char[] ca = str.toCharArray();
        char[] temp = ca;
        int n = end - start;
        
        for(int i = 0; i < n; i++){
            ca[start+i] = temp[end-i];
        }
        return String.valueOf(ca);
    }
    
    public String solution(String my_string, int[][] queries) {
        for(int i = 0; i < queries.length; i++){
            my_string = reverseStr(my_string, queries[i][0], queries[i][1]);
        }
        return my_string;
    }
}