import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				if (a[0] == b[0]) return a[1] - b[1];
				return a[0] - b[0];
			}
		});
		
		int answer = 0;
		
		int cur = arr[0][0];
		for (int i = 0; i < N; i++) {
			if (cur <= arr[i][0]) {
				answer += arr[i][1] - arr[i][0];
				cur = arr[i][1];
			} else if (arr[i][0] < cur && cur < arr[i][1]) {
				answer += arr[i][1] - cur;
				cur = arr[i][1];
			}
		}
		
		System.out.println(answer);
	}

}