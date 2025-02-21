class Solution {
    public boolean solution(String s) {
        char[] ca = s.toCharArray();
        if(ca.length == 4 || ca.length == 6){
            for(int i = 0; i < ca.length; i++){
                if(ca[i] > '9' || ca[i] < '0')
                    return false;
            }
        }else
            return false;
        return true;
    }
}