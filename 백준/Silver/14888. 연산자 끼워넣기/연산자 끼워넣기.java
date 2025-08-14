import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N, max, min;
    static int[] num;
    static int[] op;
    
    static void dfs(int depth, int res) {
        if(depth == N-1){
            max = Math.max(max, res);
            min = Math.min(min, res);
        }
        
        for(int i = 0; i < 4; i++){
            if(op[i] > 0){
                op[i] -= 1;
                switch(i){
                    case 0:
                        dfs(depth+1, res+num[depth+1]);
                        break;
                    case 1:
                        dfs(depth+1, res-num[depth+1]);
                        break;
                    case 2:
                        dfs(depth+1, res*num[depth+1]);
                        break;
                    case 3:
                        dfs(depth+1, res/num[depth+1]);
                        break;
                }
                op[i] += 1;
            }
        }
    }
    
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new int[N + 1];
        op = new int[4];
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++){
            op[i] = Integer.parseInt(st.nextToken());
        }
        
        dfs(0, num[0]);
        
        System.out.println(max);
        System.out.println(min); 
    }
}