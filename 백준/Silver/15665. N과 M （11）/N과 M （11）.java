import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] numArr;
    static int[] arr;
    static StringBuilder sb;
   
    static void func(int k){
        if(k == M){
            for(int i = 0; i < M; i++){
                sb.append(arr[i]).append(' ');
            }
            sb.append('\n');
            return;
        }
        
        int prev = -1;
        for(int i = 0; i < N; i++){
            if(numArr[i] == prev) continue;
            prev = numArr[i];
            arr[k] = numArr[i]; 
            func(k + 1);
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
      
        numArr = new int[N];
        arr = new int[M];
        
        for(int i = 0; i < N; i++){
            numArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numArr);
        
        func(0);
        System.out.println(sb.toString());
    }
}