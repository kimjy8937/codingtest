import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }
        
        boolean[] exists = new boolean[max+1];
        int[] scores = new int[max+1];
        
        for (int x : arr) {
            exists[x] = true;
        }

        
        for(int num : arr){
            for(int i = num * 2; i <= max; i += num){
                if(exists[i]){
                    scores[i]--;
                    scores[num]++;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int x : arr) {
            sb.append(scores[x]).append(' ');
        }

        System.out.println(sb);
        
    }
}