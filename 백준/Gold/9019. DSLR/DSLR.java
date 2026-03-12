import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static class Node{
        int num;
        String answer;
        Node(int num, String answer) {
            this.num = num;
            this.answer = answer;
        }
    }
    
    static int D(int num){
        return 2 * num % 10000;
    }
    
    static int S(int num){
        if(num == 0) return 9999;
        else return num-1;
    }
    
    static int L(int num) {
        return num % 1000 * 10 + (num / 1000);
    }
    
    static int R(int num) {
        return num / 10 + (num % 10 * 1000);
    }
    
    public static void main(String[] args) throws Exception{
        int c = Integer.parseInt(br.readLine());
        for(int i = 0; i < c; i++){
            String line = br.readLine();
            st = new StringTokenizer(line);
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            
            System.out.println(bfs(n1, n2));
        }
    }
    
    static String bfs(int n1, int n2){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(n1, ""));
        boolean[] visited = new boolean[10000];
        visited[n1] = true;
        while(!q.isEmpty()){
            Node now = q.poll();
            visited[now.num] = true;
            if(now.num == n2){
                return now.answer;
            }
           
            int d = D(now.num);
            int s = S(now.num);
            int l = L(now.num);
            int r = R(now.num);

            if(!visited[d]){
                visited[d] = true;
                q.offer(new Node(d, now.answer + "D"));
            }
            if(!visited[s]){
                visited[s] = true;
                q.offer(new Node(s, now.answer + "S"));
            }
            if(!visited[l]){
                visited[l] = true;
                q.offer(new Node(l, now.answer + "L"));
            }
            if(!visited[r]){
                visited[r] = true;
                q.offer(new Node(r, now.answer + "R"));
            }
        }
        return "";
    }
}