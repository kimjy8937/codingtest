import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        int[] before = new int[N + 1];
        
        for(int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;
            before[i] = i - 1;
            
            if(i % 2 == 0 && dp[i / 2] + 1 < dp[i]){
                dp[i] = dp[i / 2] + 1;
                before[i] = i / 2;
            }
            if(i % 3 == 0 && dp[i / 3] + 1 < dp[i]){
                dp[i] = dp[i / 3] + 1;
                before[i] = i / 3;
            }            
        }
        
        System.out.println(dp[N]);
        int num = N;
        while(num != 0) {
            sb.append(num).append(' ');
            num = before[num];
        }
        System.out.println(sb.toString());
    }
}