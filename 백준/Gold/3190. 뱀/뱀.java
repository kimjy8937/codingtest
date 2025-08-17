import java.io.*;
import java.util.*;

public class Main {

	public static class Node {
		int x;
		int y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static int[] dx = {0, 1, 0, -1};
	public static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Integer, String> change = new HashMap<Integer, String>();
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		int[][] map = new int[n+1][n+1];
		for(int i=0;i<k;i++) {
			String[] data = br.readLine().split(" ");
			int r = Integer.parseInt(data[0]);
			int c = Integer.parseInt(data[1]);
			map[r][c] = 1;
		}
		
		int l = Integer.parseInt(br.readLine());
		for(int i=0;i<l;i++) {
			String[] data = br.readLine().split(" ");
			change.put(Integer.parseInt(data[0]), data[1]);
		}
		
		int time = 0;
		int nx = 1;
		int ny = 1;
		int dir = 0;
		Queue<Node> snack = new LinkedList<>();
		snack.offer(new Node(nx, ny));
		map[1][1] = 2; // 뱀 표시
		
		while(true) {
			time++;
			nx += dx[dir];
			ny += dy[dir];
			if(nx < 1 || nx > n || ny < 1 || ny > n || map[nx][ny] == 2) {
				break;
			}
			// 사과 유무
			if(map[nx][ny] == 1) {
				map[nx][ny] = 0;
			} else {
				Node tail = snack.poll();
				map[tail.x][tail.y] = 0;
			}
			snack.add(new Node(nx, ny));
			map[nx][ny] = 2;
			
			if(change.containsKey(time)) {
				String change_dir = change.get(time);
				if(change_dir.equals("L")) {
					dir = (dir==0?3:dir-1);
				} else {
					dir = (dir==3?0:dir+1);
				}
			}
			
		}
		
		System.out.println(time);

	}

}