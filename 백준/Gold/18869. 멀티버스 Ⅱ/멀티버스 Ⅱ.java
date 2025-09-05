import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] arr = new int[M][N];
		List<Integer>[] list = new ArrayList[M];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			Set<Integer> set = new HashSet<>();

			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				arr[i][j] = num;
				set.add(num);
			}

			list[i] = new ArrayList<>(set);
			Collections.sort(list[i]);
		}

		for (int i = 0; i < M; i++)
			for (int j = 0; j < N; j++)
				arr[i][j] = Collections.binarySearch(list[i], arr[i][j]);

		int count = 0;
		for (int i = 0; i < M; i++) {
			for (int j = i + 1; j < M; j++) {
				if (Arrays.equals(arr[i], arr[j]))
					count++;
			}
		}

		System.out.println(count);
	}
}