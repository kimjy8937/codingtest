import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        long sum = 0;
        int[] arr = new int[K];
        for(int i = 0; i < K; i++){
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        
        long right = sum / K;
        long left = 1;
        long answer = 0;

    
        while(left <= right){
            long mid = (left + right) / 2;
            int count = 0; 
            for(int i = 0; i < K; i++){
                count += arr[i] / mid;
            }
            if(count >= N){
                answer = mid;
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }
}