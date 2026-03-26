import java.io.*;
import java.util.*;

public class Main {
    static int N, M, B;
    static int[][] map;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        int max = 0; 
        int min = 256;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, map[i][j]);
                max = Math.max(max, map[i][j]);
            }
        }
        
        int answer1 = 0;
        int answer2 = Integer.MAX_VALUE;
        for(int i = min; i <= max; i++){
            int block = B;
            int count = 0;
            int time = 0;
            for(int j = 0; j < N; j++){
                for(int k = 0; k < M; k++){
                    if(map[j][k] > i){
                        time += (map[j][k] - i) * 2;
                        block += (map[j][k] - i);
                    }else{
                        count += (i - map[j][k]);
                        time += (i - map[j][k]);
                    }
                }
            }
            if(count > block){
                continue;
            }else if (time < answer2) {
                answer2 = time;
                answer1 = i;
            } else if (time == answer2 && i > answer1) {
                answer1 = i;
            }
        }
 
        System.out.print(answer2 + " " + answer1);
    }
}