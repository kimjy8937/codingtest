import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static ArrayList<Integer>[] graph;
    
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        
        int answer = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= N; i++){
            int sum = bfs(i);
            if(min > sum){
                min = sum;
                answer = i;
            }
        }
        System.out.print(answer);
    }
    
    static int bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N+1];
        int[] dist = new int[N+1];
        
        q.offer(start);
        visited[start] = true;
        while(!q.isEmpty()){
            int now = q.poll();
            for(int num : graph[now]){
                if(!visited[num]){
                    visited[num] = true;
                    q.offer(num);
                    dist[num] = dist[now] + 1;
                }
            }
        }
        int sum = 0;
        for(int i = 1; i <= N; i++){
            sum += dist[i];
        }
        return sum;
    }
}