import java.io.*;
import java.util.*;

public class Main{
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int[] count = new int[100001];
        int answer = 0;
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int left = 0;
        for(int right = 0; right < N; right++){
            count[arr[right]]++;

            while(count[arr[right]] > K){
              count[arr[left]] --;
              left += 1; 
            }

            answer = Math.max(answer, right - left + 1);
        }
        System.out.print(answer);
    }
}