// import java.util.Arrays;
class Solution {
    public String solution(String my_string, int[] indices) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<my_string.length(); i++){
            int check = 0;
            for(int j = 0; j<indices.length; j++){
                if (i == indices[j]){
                    check++;
                    break;
                }
            }
            if(check == 0)
                sb.append(my_string.charAt(i));
        }
        
        return sb.toString();
    }
}