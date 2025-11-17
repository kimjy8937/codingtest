import java.util.*;

class Solution {
    static char[][] arr;
    static boolean[][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public int solution(String[] maps) {
        int a = maps.length;
        int b = maps[0].length();

        int[] start = new int[2];
        int[] lever = new int[2];
        int[] end = new int[2];

        arr = new char[a][b];
        visit = new boolean[a][b];

        for(int i = 0; i<a; i++) {
            for(int j =0; j<b; j++){

                arr[i][j] = maps[i].charAt(j);

                if (arr[i][j]=='S') {
                    start = new int[]{i,j};
                }

                if (arr[i][j]=='L') {
                    lever = new int[]{i,j};
                }     

                if (arr[i][j]=='E') {
                    end = new int[]{i,j};
                }     
            }
        }

        int Midpoint = bfs(start,lever);
        visit = new boolean[a][b];
        
        int Endpoint = bfs(lever,end);

        if (Midpoint == 0 || Endpoint == 0){
           return -1;
        }

        return Midpoint + Endpoint;
    }


    public int bfs(int[] node1, int[] node2) {
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[]{node1[0], node1[1], 0});

        while(!q.isEmpty()) {
              int[] p = q.poll();
              visit[p[0]][p[1]] = true;

              for(int i = 0; i<4; i++) {
                  int nx = p[0] + dx[i];
                  int ny = p[1] + dy[i];

                   if(nx>=0 && nx<arr.length && ny>=0 && ny<arr[0].length && arr[nx][ny]!='X' && !visit[nx][ny]){
                    visit[nx][ny]=true; 
                    q.add(new int[]{nx, ny, p[2]+1});

                   }
              }

              if(p[0]==node2[0] && p[1]==node2[1]) {
                  return p[2];
              } 
        }
        return 0;
    }
}