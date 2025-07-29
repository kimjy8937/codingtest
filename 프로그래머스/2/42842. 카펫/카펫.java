class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
    
        for(int x = 3; x <= (brown - 2)/2; x++) {
            for(int y = 3; y <= x; y++){
                if(2*x + 2*(y-2) == brown && (x-2) * (y-2) == yellow){
                    answer[0] = x;
                    answer[1] = y;
                }
            }
        }
        return answer;
    }
}