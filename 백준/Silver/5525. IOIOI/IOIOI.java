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

        int count = 0;
        int answer = 0;
        
        if(S.length() <= 2){
            System.out.println(0);
            return;
        }
        
        for(int i = 0; i < M-2; i++){
            if (S.charAt(i) == 'I' && S.charAt(i+1) == 'O' && S.charAt(i+2) == 'I'){
              count++;
              if(count >= N){
                answer++;
              }
              i++;
            } else {
              count = 0;
            }
        }
        System.out.println(answer);
    }
}