import java.util.*;
import java.io.*;

class Solution {
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    static int bfs(int[][] maps) {
        Queue<int[]> que = new ArrayDeque<>();
        que.offer(new int[] {0, 0, 1});
        visited[0][0] = true;
        int min = 100000;
        
        while(!que.isEmpty()) {
            int[] temp = que.poll();
            int nx = temp[0];
            int ny = temp[1];
            int n = temp[2];
            
            if(nx == maps.length-1 && ny == maps[0].length-1){
                if(min > n){
                    min = n;
                }
            }
            for(int i = 0; i < 4; i++){
                int cx = nx + dx[i];
                int cy = ny + dy[i];
                
                if(cx < 0 || cy < 0 || cx > maps.length-1 || cy > maps[0].length-1) continue;
                if(visited[cx][cy] || maps[cx][cy] == 0) continue;
                que.offer(new int[] {cx, cy, n + 1});
                visited[cx][cy] = true;
            }   
        }
        if(min == 100000){
            return -1;
        }else{
            return min;
        }
    }
    public int solution(int[][] maps) {
        int answer = 0;
        visited = new boolean[maps.length][maps[0].length];
        
        answer = bfs(maps);
        
        return answer;
    }
}