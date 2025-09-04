import java.io.*;

public class Main {
	
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		String[] nm = br.readLine().split(" ");
		int N = Integer.parseInt(nm[0]);
		int M = Integer.parseInt(nm[1]);
		
		int use = 0;
		int max = 0;
		int[] tree = new int[N];
		String[] split = br.readLine().split(" ");
		for(int i=0;i<N;i++) {
			tree[i] = Integer.parseInt(split[i]);
			max = Math.max(max, tree[i]);
		}
		while(use < max) {
			int mid = (use + max) /2;
			long sum = 0;
			for(int h: tree) {
				if(h-mid>0) {
					sum+=h-mid;
				}
			}
			if(sum < M) {
				max = mid;
			}
			else {
				use = mid + 1;
			}
		}
		
		System.out.println(use-1);
	}
}