import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] roads = new int[N-1];
        int[] prices = new int[N];
        int totalPrice = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N-1; i++) {
            roads[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N - 1; i++) {
            if(prices[i] < prices[i+1]) {
                prices[i + 1] = prices[i];
            }
        }

        for(int i = 0; i < N - 1; i++) {
            totalPrice += prices[i] * roads[i];
        }

        System.out.println(totalPrice);
    }
}
