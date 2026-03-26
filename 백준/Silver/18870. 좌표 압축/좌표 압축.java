import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        
        int[] nums = new int[N];
        int[] sorted = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
            sorted[i] = nums[i];
        } 
        Arrays.sort(sorted);
        
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 0;

        for (int i = 0; i < N; i++) {
            if (!map.containsKey(sorted[i])) {
                map.put(sorted[i], rank++);
            }
        }

        for (int i = 0; i < N; i++) {
            sb.append(map.get(nums[i])).append(' ');
        }

        System.out.print(sb);
        
    }
}