import java.util.*;
import java.io.*;

public class Main{
    static int k;
    static int[] S;
    static int[] selected;
    static boolean[] vis;
    static StringBuilder sb = new StringBuilder();
    
    static void func(int start, int depth) {
        if (depth == 6) {
            for (int s : selected) {
                sb.append(s).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = start; i < k; i++){
            if(!vis[i]){
                vis[i] = true;
                selected[depth] = S[i];
                func(i, depth + 1);
                vis[i] = false;
            }
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if (k == 0)
                break;
            S = new int[k];
                    
            for(int i = 0; i < k; i++){
                S[i] = Integer.parseInt(st.nextToken());
            }
            
            selected = new int[6];
            vis = new boolean[k];
            sb = new StringBuilder();
            func(0, 0);
            
            System.out.println(sb); 
        }
    }
}