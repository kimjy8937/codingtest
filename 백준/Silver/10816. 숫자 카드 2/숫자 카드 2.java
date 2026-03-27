import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int n = Integer.parseInt(st.nextToken());
            if(!map.containsKey(n)){
                map.put(n, 1);
            }else{
                map.put(n, map.get(n)+1);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            int m = Integer.parseInt(st.nextToken());
            if(map.containsKey(m)){
                sb.append(map.get(m)).append(' ');
            }else {
                sb.append(0).append(' ');
            }
            
        }
        System.out.println(sb.toString());
    }
    
}