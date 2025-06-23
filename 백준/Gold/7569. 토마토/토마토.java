import java.util.*;
import java.io.*;

public class Main{
    static int M, N, H;
    static int day;
    static int[][][] box;
    static boolean[][][] vis;
    static int[] dx = { 0, 0, 0, -1, 0, 1 };
	static int[] dy = { 0, 0, 1, 0, -1, 0 };
    static int[] dz = { 1, -1, 0, 0, 0, 0};
    static Queue<int[]> que;
    
    static void bfs(){
        day = -1;
        while(!que.isEmpty()){
            int size = que.size();
            for(int q = 0; q < size; q++){
              int[] temp = que.poll();
              int z = temp[0];
              int x = temp[1];
              int y = temp[2];
              
              for (int i = 0; i < 6; i++) {
                int cz = z + dz[i];
                int cx = x + dx[i];
  				int cy = y + dy[i];
  
                if (cz < 0 || cx < 0 || cy < 0 || cz >= H
                     || cx >= N || cy >= M) continue;
  				if (box[cz][cx][cy] == 0) {
                      box[cz][cx][cy] = 1;
                      que.add(new int[] {cz, cx, cy});
                  }
              }
            }
            day++;
        }
    }
    
    public static int checkTomato(){
        for(int i = 0; i < H; i++){
            for(int j = 0; j < N; j++){
                for(int k = 0; k < M; k++){
                    if(box[i][j][k] == 0){
                        return -1;
                    }
                }
            }
        }
        return day;
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        
        box= new int[H][N][M];
        vis = new boolean[H][N][M];
        
        que = new LinkedList<>();
        boolean flag = true;
        
        for (int i=0 ; i<H; i++){
            for(int j = 0 ; j <N ; j++){
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++){
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if(box[i][j][k]==1){
                        que.add(new int[]{i,j,k});
                    }
                    if(flag && box[i][j][k] == 0) flag = false;
                }
            }
        }
        
        if(flag)
            System.out.println(0);
        else{
            bfs();
            System.out.println(checkTomato());
        }
    }

}