import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        
        Queue<Integer> trucks = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            trucks.offer(Integer.parseInt(st.nextToken()));
        }
        int time = 0;
        int bw = 0;
        Queue<Integer> que = new ArrayDeque<>();
        for(int i = 0; i < w ; i++){
            que.add(0);
        }
        
        while(!que.isEmpty()){
            time++;
            bw -= que.poll();
            if(!trucks.isEmpty()) {
                if(trucks.peek()+bw <= L) {
                    bw += trucks.peek();
                    que.offer(trucks.poll());
                }else {
                    que.offer(0);
                }
            }
        } 
        System.out.println(time);
    }
}