import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String A = br.readLine();
    	String B = br.readLine();
    	String C = br.readLine();
    	
    	System.out.println(Integer.parseInt(A) + Integer.parseInt(B) - Integer.parseInt(C));
    	System.out.println(Integer.parseInt(A+B) - Integer.parseInt(C));
    }
}