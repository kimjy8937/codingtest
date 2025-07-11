import java.util.*;
import java.io.*;

public class Main {
	
	static int N, eggs[][], answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		eggs = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			eggs[i][0] = Integer.parseInt(st.nextToken());
			eggs[i][1] = Integer.parseInt(st.nextToken()); 
		}
		
		dfs(0, 0);
		
		System.out.println(answer);
	}

	static void dfs(int cur, int cnt) {
		
		if (cur == N) { 
            answer = Math.max(answer, cnt);
			return;
		}
		
		if (eggs[cur][0] <= 0 || cnt == N - 1) {
			dfs(cur + 1, cnt);
			return;
		}
		
		int w1 = eggs[cur][1];
		
		for (int next = 0; next < N; next++) {
			if (cur == next || eggs[next][0] <= 0) continue;
			
			int w2 = eggs[next][1];
			
			eggs[cur][0] -= w2;
			eggs[next][0] -= w1;
			if (eggs[cur][0] <= 0 && eggs[next][0] <= 0) {
				dfs(cur + 1, cnt + 2);
			} else if (eggs[cur][0] > 0 && eggs[next][0] > 0) { 
				dfs(cur + 1, cnt);
			} else { 
				dfs(cur + 1, cnt + 1);
			}
			eggs[next][0] += w1;
			eggs[cur][0] += w2;
		}
		
	}
}