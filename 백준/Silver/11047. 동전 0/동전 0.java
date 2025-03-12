import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.*;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int coinNum = Integer.parseInt(st.nextToken());
        int amount = Integer.parseInt(st.nextToken());
        int count = 0;
        Integer[] coins = new Integer[coinNum];

        for(int i = 0; i < coinNum; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(coins, (a, b) ->
                b - a
        );

        for (Integer coin : coins) {
            count += amount / coin;
            amount %= coin;
        }
        System.out.println(count);
    }
}
