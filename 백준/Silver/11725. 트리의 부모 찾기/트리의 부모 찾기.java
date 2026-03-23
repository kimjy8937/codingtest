import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static int[] answer;
    
    static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        while(!q.isEmpty()){
            int now = q.poll();
            for(int num: graph[now]) {
                if(answer[num] == 0){
                    answer[num] = now;
                    q.offer(num);
                }
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        answer = new int[N+1];
        graph = new ArrayList[N+1];
        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        
        bfs();
        
        for(int i = 2; i <= N; i++){
            System.out.println(answer[i]);
        }
    }
}