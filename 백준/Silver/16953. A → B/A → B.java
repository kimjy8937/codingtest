import java.io.*;
import java.util.*;

public class Main {
	
	static class Node {
		long n; int count;
		Node(long n, int count) {
			this.n = n;
			this.count = count;
		}
	}
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	long A = Long.parseLong(st.nextToken());
    	long B = Long.parseLong(st.nextToken());
    	
    	int answer = -1;
    	
    	Queue<Node> q = new LinkedList<>();
    	q.offer(new Node(A, 1));
    	
    	while(!q.isEmpty()) {
    		Node now = q.poll();
    		if(now.n == B) {
    			answer = now.count;
    			break;
    		}
    		if(now.n * 2 <= B) {
    			q.offer(new Node(now.n * 2, now.count + 1));
    		}
    		if((now.n * 10 + 1) <= B) {
    			q.offer(new Node(now.n * 10 + 1, now.count + 1));
    		}
    	}
    	
    	System.out.println(answer);
    }
}