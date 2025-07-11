import java.io.*;
import java.util.*;

public class Main {
	
	private static class Info {
		
		int R, C;

		public Info(int r, int c) {
			super();
			R = r;
			C = c;
		}
		
	}
	
	private static String[][] map = new String[5][5];
	private static boolean[] checked = new boolean[25];
	private static boolean[][] visited = new boolean[5][5];
	private static int[] moveY = { -1,0,1,0 };
	private static int[] moveX = { 0,-1,0,1 };
	private static int answer;
	private static StringBuilder sb = new StringBuilder();
	
	private static void init() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				visited[i][j] = false;
			}
		}
	}
	
	private static boolean bfs(int R, int C) {
		init();
		
		Queue<Info> queue = new LinkedList<>();
		int nowS = 0;
		int nowY = 0;
		
		visited[R][C] = true;
		if ("S".equals(map[R][C])) {
			queue.add(new Info(R, C));
			nowS++;
		} else {
			queue.add(new Info(R, C));
			nowY++;
		}
		
		while (!queue.isEmpty()) {
			Info now = queue.poll();
			int nowR = now.R;
			int nowC = now.C;
			
			for (int i = 0; i < 4; i++) {
				int nextR = nowR + moveY[i];
				int nextC = nowC + moveX[i];
				if ((nextR >= 0) && (nextR < 5) && (nextC >= 0) && (nextC < 5) && checked[nextR * 5 + nextC] && !visited[nextR][nextC]) {
					visited[nextR][nextC] = true;
					if ("S".equals(map[nextR][nextC])) {
						queue.add(new Info(nextR, nextC));
						nowS++;
					} else {
						queue.add(new Info(nextR, nextC));
						nowY++;
					}
				}
			}
		}
		
		if ((nowS + nowY == 7) && (nowS >= 4)) {
			return true;
		}
		
		return false;
	}
	
	private static void dfs(int depth, int start) {
		if (depth == 7) {
			boolean flag = bfs(start / 5, start % 5);
			if (flag) {
				answer++;
			}
			
			return;
		}
		
		for (int i = (start + 1); i < 25; i++) {
			if (!checked[i]) {
				checked[i] = true;
				dfs(depth + 1, i);
				checked[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for (int i = 0; i < 5; i++) {
			String[] inputs = br.readLine().split("");
			for (int j = 0; j < 5; j++) {
				map[i][j] = inputs[j];
			}
		}
		
		dfs(0, -1);
		
		sb.append(answer + "\n");
		
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

}