import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int sum = 0;
    	while(st.hasMoreTokens()) {
    		int num = Integer.parseInt(st.nextToken());
    		sum += num * num;
    	}
    	System.out.println(sum % 10);
    }
}