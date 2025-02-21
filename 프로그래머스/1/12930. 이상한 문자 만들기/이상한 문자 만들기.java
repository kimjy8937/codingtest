class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == ' '){
                count = 0;
                sb.append(' ');
                continue;
            }
            if(count % 2 == 0)
                sb.append(Character.toUpperCase(s.charAt(i)));
            else
                sb.append(Character.toLowerCase(s.charAt(i)));
            count++;  
        }
        return sb.toString();
    }
        
      

}