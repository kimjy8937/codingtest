class Solution {
    public int[] solution(int brown, int yellow) {
        int x=0,y=0;
        for(y=1;y<=yellow;y++) {
            x=yellow/y;
            if(y*x!=yellow){
                continue;
            }

            if((x+y)==((brown/2)-2)) {
                break;
            }

        }

        int[] answer = {x+2,y+2};
        return answer;
    }
}