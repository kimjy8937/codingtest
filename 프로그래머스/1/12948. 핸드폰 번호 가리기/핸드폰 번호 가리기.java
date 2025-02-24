class Solution {
    public String solution(String phone_number) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< phone_number.length(); i++){
            if(i < phone_number.length()-4)
                sb.append('*');
            else
                sb.append(phone_number.charAt(i));
        }
        
        return sb.toString();
    }
}