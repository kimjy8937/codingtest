import java.util.*;
import java.io.*;

public class Main {
        static int N, M;
        static int[] arr = new int[10];
        static StringBuilder sb;
    
        static void func(int k){
            if(k == M){
                for(int i = 0; i < M; i++){
                    sb.append(arr[i]).append(' ');
                }
                sb.append('\n');
                return;
            }
            for(int i = 1; i <= N; i++) {
                    arr[k] = i;
                    func(k+1);
            }
        }
    
        public static void main(String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            sb = new StringBuilder();
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            func(0);
            System.out.println(sb.toString());
        }
}