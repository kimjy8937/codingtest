import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String S = br.readLine();
    	int i = Integer.parseInt(br.readLine());
    	
    	System.out.println(S.charAt(i-1));
    }
}