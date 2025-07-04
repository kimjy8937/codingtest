import java.util.*;
import java.io.*;

public class Main{
    static int N, M;
    static int arr[];
    static int numArr[];
    static boolean vis[];
    static StringBuilder sb;
    
    static void func(int k){
        if(k == M){
            for(int i = 0; i < M; i++){
                sb.append(arr[i]).append(' ');
            }
            sb.append('\n');
            return;
        }
        for(int i = 0; i < N; i++){
            if(!vis[i]){
                arr[k] = numArr[i];
                vis[i] = true;
                func(k + 1);
                vis[i] = false;
            }
        }
    }
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        numArr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            numArr[i] = Integer.parseInt(st.nextToken());
        }
        
        vis = new boolean[N];
        arr = new int[10];
        Arrays.sort(numArr);
        func(0);
        System.out.println(sb.toString());
    }
}