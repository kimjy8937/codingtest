class Solution {
    public int[] solution(int start, int end) {
        int[] answer = new int[end - start+1];
        for(int i =0; i<= end - start; i++) {
            answer[i] = start + i;
        }
        return answer;
    }
}