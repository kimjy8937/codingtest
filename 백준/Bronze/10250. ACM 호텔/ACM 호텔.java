import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int T = Integer.parseInt(br.readLine());
    	
    	for(int i = 0; i < T; i ++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int H = Integer.parseInt(st.nextToken());
    		int W = Integer.parseInt(st.nextToken());
    		int N = Integer.parseInt(st.nextToken());

            int floor = N % H == 0 ? H : N % H;
    		
    		System.out.println(floor * 100 + (N-1) / H + 1);
    	}
    }
}