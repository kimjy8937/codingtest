import java.io.*;
import java.util.*;

public class Main {
	static int count = 0;
	static int n, k;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.valueOf(st.nextToken());
		k = Integer.valueOf(st.nextToken());
		
		boolean[] checked = new boolean[n + 1];
		for(int i = 2; i <= n; i++) {
			if(checked[i]) {
				continue;
			}
			if(removeChecked(i, checked)) {
				break;
			}
		}
	}
	
	static boolean removeChecked(int num, boolean[] checked) {
		for(int i = num; i <= n; i += num) {
			if(checked[i])
				continue;
			checked[i] = true;
			count++;
			if(count == k) {
				System.out.println(i);
				return true;
			}
		}
		return false;
	}
}