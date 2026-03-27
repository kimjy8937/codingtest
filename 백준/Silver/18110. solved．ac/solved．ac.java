import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        if(n == 0){
            System.out.println(0);
            return;
        }
        
        int k = (int) Math.round(n * 0.15);
        
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(nums);
        
        int sum = 0;
        for(int i = k; i < n-k; i++){
            sum += nums[i];
        }
        
        int answer = (int) Math.round((double) sum / (n - 2 * k));
        System.out.println(answer);

    }
}