import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger[] dp = new BigInteger[251];

        dp[0] = new BigInteger("1");
        dp[1] = new BigInteger("1");

        while(true) {
            String str = br.readLine();
            if(str == null) break;
            else {
                int n = Integer.parseInt(str);
                if(n >= 2){
                    for(int i = 2; i <= n; i++) {
                        if(i % 2 == 0) {
                            dp[i] = dp[i-1].multiply(new BigInteger("2")).add(new BigInteger("1"));
                        }else {
                            dp[i] = dp[i-1].multiply(new BigInteger("2")).subtract(new BigInteger("1"));
                        }
                    }
                }
                System.out.println(dp[n]);
            }
        }
    }
}