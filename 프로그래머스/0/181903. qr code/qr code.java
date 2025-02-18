class Solution {
    StringBuilder sb = new StringBuilder();
    public String solution(int q, int r, String code) {
        for(int i = r; i<code.length(); i+=q){
            sb.append(code.charAt(i));
        }
        return sb.toString();
    }
}