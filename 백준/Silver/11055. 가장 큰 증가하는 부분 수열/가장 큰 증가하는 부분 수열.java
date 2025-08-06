import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		int[] dp = new int[N + 1];
		int[] array = new int[N + 1];
		String[] input = br.readLine().split(" "); 
		
		
		for (int i = 1; i <= N; i++) {
			array[i] = Integer.valueOf(input[i - 1]); 
			dp[i]=array[i];
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j < i; j++) {
				if (array[i] > array[j] && dp[j] + array[i] > dp[i]) { 
					dp[i] = dp[j] + array[i]; 
                    
				}

			}
		}
		Arrays.sort(dp);
		System.out.println(dp[N]);

	}
}