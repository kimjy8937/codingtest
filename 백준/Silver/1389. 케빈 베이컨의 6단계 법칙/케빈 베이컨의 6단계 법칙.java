import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int[][] graph;
    
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        graph = new int[N+1][N+1];
        
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1;
            graph[b][a] = 1;
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
        q.offer(start);
        boolean[] visited = new boolean[N+1];
        int[] dist = new int[N+1];
        
        visited[start] = true;
        
        while(!q.isEmpty()){
            int now = q.poll();
            for(int i = 1; i <= N; i++){
                if(graph[now][i]==1 && !visited[i]){
                    visited[i] = true;
                    dist[i] = dist[now] + 1;
                    q.offer(i);
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