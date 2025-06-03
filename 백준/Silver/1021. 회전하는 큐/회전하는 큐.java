import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		LinkedList<Integer> deq = new LinkedList<Integer>();
		
		for(int i = 1; i <= N; i++) {
			deq.add(i);
		}
		int count = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			while(deq.getFirst() != num) {
				if(deq.indexOf(num) <= (deq.size() / 2)) {
					deq.addLast(deq.getFirst());
					deq.removeFirst();
				}else {
					deq.addFirst(deq.getLast());
					deq.removeLast();
				}
				count++;
			}
			if(deq.getFirst() == num) {
				deq.removeFirst();
			}
		}
		System.out.println(count);
	}

}