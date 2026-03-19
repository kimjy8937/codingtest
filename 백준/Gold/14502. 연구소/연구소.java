import java.util.*;
import java.io.*;

public class Main{
    static int N, M;
    static int[][] map;
    static int maxSafe = 0;
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    static class Node{
        int x, y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        buildWall(0);
        System.out.print(maxSafe);
    }
    
    static void buildWall(int count){
        if(count == 3){
            spreadVirus();
            return;
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 0){
                    map[i][j] = 1;
                    buildWall(count+1);
                    map[i][j] = 0;
                }
            }
        }
    }
    
    static void spreadVirus(){
        int[][] copyMap = new int[N][M];
        for(int i = 0; i < N; i++){
            copyMap[i] = map[i].clone();
        }
        
        Queue<Node> q = new LinkedList<>();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 2){
                    q.offer(new Node(i, j));
                }
            }
        }
        
        while(!q.isEmpty()){
            Node now = q.poll();
            for(int i = 0; i < 4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(copyMap[nx][ny] != 0) continue;
                copyMap[nx][ny] = 2;
                q.offer(new Node(nx, ny));
            }
        }
        countSafeArea(copyMap);
    }
    
    static void countSafeArea(int[][] copyMap){
        int safe = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(copyMap[i][j] == 0){
                    safe++;
                }
            }
        }
        maxSafe = Math.max(safe, maxSafe);
    }
}