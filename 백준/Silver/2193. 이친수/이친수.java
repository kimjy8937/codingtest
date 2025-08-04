import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[N+1];
        
        for(int i = 1; i <= N; i++){
            if(i == 1) dp[i] = 1;
            if(i == 2) dp[i] = 1;
            if(i > 2){
                dp[i] = dp[i-1] + dp[i-2];
            }
        }
        System.out.println(dp[N]);
    }
}