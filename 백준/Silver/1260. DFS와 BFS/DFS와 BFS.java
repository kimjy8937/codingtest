import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    
    static void dfs(int v) {
        visited[v] = true;
        sb.append(v).append(' ');
        for(int nx : graph[v]) {
            if(!visited[nx]) dfs(nx);
        }
    }
    
    static void bfs(int v) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(v);
        visited[v] = true;
        while(!q.isEmpty()){
            int cur = q.poll();
            sb.append(cur).append(' ');
            for(int nx : graph[cur]) {
                if(!visited[nx]){
                    visited[nx] = true;
                    q.add(nx);
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        
        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
        
        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            graph[a].add(b);
            graph[b].add(a);    //무방향
        }
        
        for(int i = 1; i <= N; i++) Collections.sort(graph[i]);
        dfs(V);
        System.out.println(sb.toString().trim());
        sb = new StringBuilder();
        visited = new boolean[N+1];
        bfs(V);
        System.out.println(sb.toString().trim());
    }
    
    
}