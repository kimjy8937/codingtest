import java.util.*;
class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[][] map =new int[N][N];
        
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (i == j){                                  
                    continue;
                }
                map[i][j] = 500001;  
            }
        }
        for(int[] data:road){
            if(map[data[0]-1][data[1]-1]<data[2]){
                continue;
            }
            map[data[0]-1][data[1]-1]=data[2];
            map[data[1]-1][data[0]-1]=data[2];
        }
        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map.length; j++) {
                for(int k=0; k<map.length; k++) {
                    if(map[j][k] > map[j][i] + map[i][k])
                        map[j][k] = map[j][i] + map[i][k];
                }
            }
        }
        for (int i = 0; i < map[0].length; i++) {
            if (map[0][i] <= K) 
                answer++;
        }
        
        return answer;
    }
}
