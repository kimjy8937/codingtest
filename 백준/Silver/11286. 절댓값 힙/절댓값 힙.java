import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
          if(Math.abs(a) == Math.abs(b)){
            return a - b;
          }
          return Math.abs(a) - Math.abs(b);
        });
        for(int i = 0; i < N; i++){
            int op = Integer.parseInt(br.readLine());
            if(op == 0){
                if(pq.isEmpty()){
                  sb.append(0).append('\n');
                }else {
                  sb.append(pq.poll()).append('\n');    
                }         
            } else{
                pq.offer(op);
            }
        }
        System.out.print(sb);
    }  
}