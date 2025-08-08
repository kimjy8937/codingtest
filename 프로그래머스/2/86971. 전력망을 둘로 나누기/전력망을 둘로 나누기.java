import java.util.*;
class Solution {
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    static int cnt = 0;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        graph = new ArrayList[n+1];
        visited = new boolean[n+1];
        
        for(int i = 1 ; i<= n ; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < wires.length ; i++){
            int u = wires[i][0];
            int v = wires[i][1];
            
            graph[u].add(v);
            graph[v].add(u);
        }
        
        for(int i = 0 ; i< wires.length; i++){
            int u = wires[i][0];
            int v = wires[i][1];
            
            graph[u].remove((Integer)v);
            graph[v].remove((Integer)u);
            
            dfs(1);
            answer = Math.min(answer, Math.abs(cnt - (n-cnt)));
            
            cnt = 0;
            Arrays.fill(visited, false);
            graph[u].add(v);
            graph[v].add(u);
            
        }
        
        
        return answer;
    }
    private void dfs(int node){
        visited[node] = true;
        cnt++;
        for(int next : graph[node]){
            if(!visited[next])
              dfs(next);  
        }
    }
}