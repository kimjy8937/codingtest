import java.io.*;
import java.util.*;

public class Main {
	static int[] parents;
	
	static int find(int p) {
		if(parents[p] == p) {
			return p;
		}
		return parents[p] = find(parents[p]);
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		parents[a] = b;
	}
	
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int G = Integer.parseInt(br.readLine());
    	int P = Integer.parseInt(br.readLine());
    	
    	parents = new int[G+1];
    	int answer = 0;
    	
    	for(int i = 1; i <= G; i++) {
    		parents[i] = i;
    	}
    	
    	for(int i = 0; i < P; i++) {
    		int plane = Integer.parseInt(br.readLine());
    		int dock = find(plane);
    		if(dock == 0) break;
    		
    		answer++;
    		union(dock, dock-1);
    	}
    	
    	
    	System.out.println(answer);
    }
}