class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        int arrLen = (intervals[0][1] - intervals[0][0] + 1)
                + (intervals[1][1] - intervals[1][0] + 1);
        int[] answer = new int[arrLen];
        
        for(int i = 0; i < (intervals[0][1] - intervals[0][0] + 1); i++){
            answer[i] = arr[intervals[0][0] + i];
        }
        for(int j = 0; j < (intervals[1][1] - intervals[1][0] + 1); j++){
            answer[j + (intervals[0][1] - intervals[0][0] + 1)] = arr[intervals[1][0] + j];
        }
        
        return answer;
    }
}