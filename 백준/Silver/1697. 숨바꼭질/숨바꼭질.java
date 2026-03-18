import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean[] visited = new boolean[100001];
    static int N, K;
    
    static class Node{
        int n, t;
        Node(int n, int t){
            this.n = n;
            this.t = t;
        }
    }
    
    static int bfs(int n){
        visited[n] = true;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(n, 0));
        int min = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            Node now = q.poll();
            if(now.n == K){
                min = Math.min(min, now.t);
                break;
            }
            
            if(now.n+1 <= 100000 && !visited[now.n+1]){
                q.offer(new Node(now.n+1, now.t+1));
            }
            if(now.n-1 >= 0 && !visited[now.n-1]){
                q.offer(new Node(now.n-1, now.t+1));
            }
            if(now.n*2 <= 100000 && !visited[now.n*2]){
                q.offer(new Node(now.n*2, now.t+1));
            }
            
            visited[now.n] = true;
        }
        return min;
    }
    
    public static void main(String[] args) throws Exception{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        System.out.print(bfs(N));
    }
}