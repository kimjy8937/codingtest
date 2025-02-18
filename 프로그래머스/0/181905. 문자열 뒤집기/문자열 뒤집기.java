class Solution {
    public String solution(String my_string, int s, int e) {
        char[] ca = my_string.toCharArray();
        char temp;
        for(int i=0; i<(e-s)/2 + 1 ; i++){
            temp = ca[s+i];
            ca[s+i] = ca[e-i];
            ca[e-i] = temp;
        }
        return String.valueOf(ca);
    }
}