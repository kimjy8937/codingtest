import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    public static void main(String[] args) throws Exception{
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        
        int left = 0;
        int right = N-1;
        int min = Integer.MAX_VALUE;
        int answerL = 0;
        int answerR = 0;
        while(left < right){
            int sum = nums[left] + nums[right];
            if(min > Math.abs(sum)){
                answerL = nums[left];
                answerR = nums[right];
                min = Math.abs(sum);
            }
            if(sum < 0){
                left++;
            }else if(sum > 0){
                right--;
            }else{
                System.out.print(nums[left] + " " + nums[right]);
                return;
            }
        } 
        System.out.print(answerL + " " + answerR);
    }
}