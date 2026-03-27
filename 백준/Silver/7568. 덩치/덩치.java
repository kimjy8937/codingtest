import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] w = new int[N];
        int[] h = new int[N];
        int[] rank = new int[N];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            h[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(w[j] > w[i] && h[j] > h[i]){
                    rank[i]++;
                }
            }
        }
        for(int i = 0; i < N; i++){
            System.out.print(rank[i]+1);
            System.out.print(' ');
        }
    }
}