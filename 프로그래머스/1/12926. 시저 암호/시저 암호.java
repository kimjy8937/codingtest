class Solution {
    public String solution(String s, int n) {
        char[] ca = s.toCharArray();
        String answer;
        for(int i = 0; i < ca.length; i++){
            if(ca[i] != ' '){
                if(ca[i] >= 'a' && ca[i] <= 'z'){
                    if(ca[i] + n > 'z')
                        ca[i] = (char)(ca[i] + n - 26);
                    else
                        ca[i] += n;
                }else if(ca[i] >= 'A' && ca[i] <= 'Z'){
                    if(ca[i] + n > 'Z')
                        ca[i] = (char)(ca[i] + n - 26);
                    else
                        ca[i] += n;
                } 
            }
        }
        answer = new String(ca);
        return answer;
    }
}