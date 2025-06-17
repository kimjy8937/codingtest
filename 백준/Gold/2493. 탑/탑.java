import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer stz = new StringTokenizer(br.readLine());
		ArrayDeque<int[]> st = new ArrayDeque<>();
		
		for(int n = 1; n <= N; n++) {
			int current = Integer.parseInt(stz.nextToken());
			while(!st.isEmpty()) {
				if(st.peek()[1] < current) st.pop(); 
				else {
					System.out.print(st.peek()[0] + " ");
					break;
				}
			}
			if(st.isEmpty()) System.out.print("0 ");
			st.push(new int[] {n, current});
		}
	}
}

