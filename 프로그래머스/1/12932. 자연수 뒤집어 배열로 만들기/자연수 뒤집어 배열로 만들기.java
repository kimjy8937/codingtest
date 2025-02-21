
class Solution {
    public int[] solution(long n) {
        String nstr = n + "";
        int[] answer = new int[nstr.length()];
        System.out.println(nstr.length());
        
        for(int i = 0; i < nstr.length(); i++ ){
            answer[nstr.length()-i-1] = nstr.charAt(i)-'0';
        }
        return answer;
    }
}