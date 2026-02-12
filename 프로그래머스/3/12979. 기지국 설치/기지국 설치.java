class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int position = 1; 
        int stationIdx = 0; 

        while (position <= n) {
            if (stationIdx < stations.length && position >= stations[stationIdx] - w) {
                position = stations[stationIdx] + w + 1;
                stationIdx++;
            } else {
                answer++;
                position += 2 * w + 1;
            }
        }
        return answer;
    }
}