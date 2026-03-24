import java.io.*;
import java.util.*;

public class Main {
	
	// BFS로 4가장자리에서 외부공기를 2로 채우기
	// 2와 2개 맞닿아있는 치즈 녹이기 <- 2로 변경
	// 반복진행
	static int N, M;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	static int[][] map;
	
	static class Node{
		int x, y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static void fillOutside(int x, int y) {
		Queue<Node> q = new ArrayDeque<>();
		q.offer(new Node(x, y));
		map[y][x] = 2;
		
		while(!q.isEmpty()) {
			Node now = q.poll();
			for(int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
				if(map[ny][nx] != 0) continue;
				
				q.offer(new Node(nx, ny));
				map[ny][nx] = 2;
			}
		}
	}
	
	static boolean checkMap() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 1) {
					return false;
				}
			}
		}
		return true;
	}
	
	static void meltCheese() {
	    List<Node> meltList = new ArrayList<>();

	    for (int y = 0; y < N; y++) {
	        for (int x = 0; x < M; x++) {
	            if (map[y][x] != 1) continue;

	            int cnt = 0;
	            for (int d = 0; d < 4; d++) {
	                int nx = x + dx[d];
	                int ny = y + dy[d];

	                if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
	                if (map[ny][nx] == 2) cnt++;
	            }

	            if (cnt >= 2) meltList.add(new Node(x, y));
	        }
	    }

	    for (Node node : meltList) {
	        map[node.y][node.x] = 2;
	        fillOutside(node.x, node.y);
	    }
	}
	
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	
    	map = new int[N][M];
    	for(int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0; j < M; j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	fillOutside(0, 0);
    	
    	int count = 0;
    	while(!checkMap()) {
    		meltCheese();
    		count++;
    	}
    	
    	System.out.println(count);
    }
}