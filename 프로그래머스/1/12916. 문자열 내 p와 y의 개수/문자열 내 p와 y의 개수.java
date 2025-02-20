class Solution {
    boolean solution(String s) {
        int numP = 0;
        int numY = 0;
        
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == 'p' || s.charAt(i) == 'P')
                numP += 1;
            else if(s.charAt(i) == 'y' || s.charAt(i) == 'Y')
                numY += 1;
        }
    
        return numP == numY;
    }
}