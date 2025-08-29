import java.util.*;

class Solution {

    List<List<Integer>> adjList = new ArrayList<>(); 
    boolean[] visited;
    int[] dist; 

    public int solution(int n, int[][] edges) {
        visited = new boolean[n];
        dist = new int[n];
		

        Arrays.fill(dist, Integer.MAX_VALUE);

        for(int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0] - 1).add(edge[1] - 1);
            adjList.get(edge[1] - 1).add(edge[0] - 1);
        }

        bfs(0);

        Arrays.sort(dist); 
        int cnt = 1;
        for(int i = dist.length - 1; i > 0; i--, cnt++) {
            if(dist[i] != dist[i - 1]) break; // 최댓값 같은게 몇개 있는지 카운트
        }
        return cnt;
    }

    private void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;
        dist[v] = 0;

        while(!queue.isEmpty()) {
            Integer w = queue.poll();
            for (Integer e : adjList.get(w)) {
                if(!visited[e]) {
                    queue.add(e);
                    visited[e] = true;
                    dist[e] = Math.min(dist[e], dist[w] + 1);
                }
            }
        }
    }
}