import java.util.*;
import java.io.*;

public class Main {
    static int N, M, V;
    static StringBuilder sb;
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    
    static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        visited = new boolean[N+1];
        visited[V] = true;
        sb.append(V).append(' ');
        q.offer(V);
        while(!q.isEmpty()){
            int now = q.poll();
            for(int num : graph[now]){
                if(!visited[num]){
                    q.offer(num);
                    visited[num] = true;
                    sb.append(num).append(' ');
                }
            }
        }
    }
    
    static void dfs(int num){
        visited[num] = true;
        sb.append(num).append(' ');
        for(int n : graph[num]){
            if(!visited[n]){
                dfs(n);
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList[N+1];
        for(int i = 1; i <= N ; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        
        for(int i = 1; i <= N; i++){
            Collections.sort(graph[i]);
        }

        visited = new boolean[N+1];
        sb = new StringBuilder();
        dfs(V);
        sb.append('\n');
        bfs();

        System.out.println(sb.toString());
    }
}