import java.util.*;
import java.io.*;

public class Main{
    static int max, N;
    static int[] T;
    static int[] P;
    
    static void dfs(int day, int pay) {
        if (day > N) {             
            max = Math.max(max, pay);
            return;
        }
        
        if (day + T[day] <= N + 1) {
            dfs(day + T[day], pay + P[day]);
        }
        
        dfs(day + 1, pay);
    }
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        T = new int[N + 1];
        P = new int[N + 1];
        
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        
        dfs(1, 0);
        System.out.println(max);
    }
    
}