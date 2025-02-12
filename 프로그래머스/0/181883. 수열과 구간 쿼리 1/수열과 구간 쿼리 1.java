class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        for(int i = 0; i < queries.length; i++){
            for(int j = queries[i][0]; j < queries[i][queries[i].length-1] + 1; j++){
                arr[j] += 1;
            }
        }    
        return arr;
    }
}