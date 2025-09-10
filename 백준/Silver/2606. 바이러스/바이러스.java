import java.io.*;
import java.util.*;

public class Main {

	static boolean[] check;
	static int[][] arr;
	static int count = 0;
	
	static int node, line;
	
	static Queue<Integer> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		node = Integer.parseInt(br.readLine());
		line = Integer.parseInt(br.readLine());
	
		arr = new int[node+1][node+1];
		check = new boolean[node+1];
		
		for(int i = 0 ; i < line ; i ++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(str.nextToken());
			int b = Integer.parseInt(str.nextToken());
			
			arr[a][b] = arr[b][a] =  1;	
		}
		
			dfs(1);
			
			System.out.println(count-1);
		
		}
	public static void dfs(int start) {
		
		check[start] = true;
		count++;
		
		for(int i = 0 ; i <= node ; i++) {
			if(arr[start][i] == 1 && !check[i])
				dfs(i);
		}
		
	}
	
}