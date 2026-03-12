import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int[][] dist;
    static final int INF = 1000000;
    
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        dist = new int[N+1][N+1];
        
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(i == j){
                    dist[i][j] = 0;
                }else{
                    dist[i][j] = INF;
                }
            }
        }
        

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            dist[a][b] = 1;
            dist[b][a] = 1;
        }
        
        for(int k = 1; k <= N; k++){
            for(int i = 1; i <= N; i++){
                for(int j = 1; j<= N; j++){
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        
        int answer = 0;
        int min = Integer.MAX_VALUE;

        for(int i = 1; i <= N; i++){

            int sum = 0;

            for(int j = 1; j <= N; j++){
                sum += dist[i][j];
            }

            if(sum < min){
                min = sum;
                answer = i;
            }
        }

        System.out.print(answer);
    }
}
