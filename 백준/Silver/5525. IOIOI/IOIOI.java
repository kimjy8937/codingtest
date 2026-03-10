import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        String S = br.readLine();
        makePn(N);
        String Pn = sb.toString();
        
        int answer = 0;
        
        if(S.length() <= 2){
            System.out.println(0);
            return;
        }
        
        for(int i = 0; i <= S.length()-(2*N+1); i++){
            if (S.substring(i, i + (2 * N + 1)).equals(Pn)){
                answer++;
            }
        }
        System.out.println(answer);
    }
    
    static void makePn(int n){
        for(int i = 0; i <= n; i++){
            sb.append('I');
            if(i != n){
                sb.append('O');
            }
        }
    }
}