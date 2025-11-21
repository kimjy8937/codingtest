import java.util.*;
class Solution {
    static int answer = Integer.MAX_VALUE;
    static int [] arx = {-1,1,0,0};
    static int [] ary = {0,0,-1,1};
    static boolean [][] red;
    static boolean [][] blue;
    static int [][] map; 
    static int a, b;
    static int rex, rey, bex, bey;
    // 0: 빈칸 1: 빨간 시작 2: 파란 시작 3: 빨간 도착 4: 파란 도착 5: 벽 
    public int solution(int[][] maze) {
        int rx = 0;
        int ry = 0;
        int bx = 0;
        int by = 0;
        a = maze.length; b = maze[0].length;
        map = new int [a][b];      // maze copy 배열 
        red  = new boolean [a][b]; // 빨간 방문 배열 
        blue = new boolean [a][b]; // 파란 방문 배열 
        for(int i = 0; i < a; i++){
            for(int j = 0; j < b; j++){
                if(maze[i][j] == 0) continue;
                
                if(maze[i][j] == 1){     // 빨간 시작 
                    red[i][j] = true;
                    rx = i; ry = j;
                }
                else if(maze[i][j] == 2){ // 파란 시작 
                    blue[i][j] = true;
                    bx = i; by = j;
                }
                else if(maze[i][j] != 5){
                    if(maze[i][j] == 3){ // 빨간 도착 
                        rex = i; rey = j;
                    } 
                    else{ // 파란 도착 
                        bex = i; bey = j;
                    }
                }
                else{
                    map[i][j] = maze[i][j]; // 벽 데이터 추가 
                }
            }
        }
        // 백트래킹 시작 
        move(rx, ry, bx, by, 0, false, false);  
      
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
    public static void move(int rx, int ry, int bx, int by, int move, boolean red_end, boolean blue_end){
    
        if(!red_end && rx == rex && ry == rey) red_end = true;
        if(!blue_end && bx == bex && by == bey) blue_end = true;
        
        if(red_end && blue_end){
            answer = Math.min(answer, move);
            return;
        }
        
        ArrayList<int[]> r_list = new ArrayList<>(); // 빨강이 이동 가능한 
        ArrayList<int[]> b_list = new ArrayList<>(); // 파랑이 이동 가능한 
        
        if(!red_end){
            for(int i = 0; i < 4; i++){
                int nx = arx[i] + rx;
                int ny = ary[i] + ry;
                if(validation(nx, ny) && map[nx][ny] != 5 && !red[nx][ny]) r_list.add(new int []{nx, ny});
            }
        }
        else r_list.add(new int []{rx, ry});
                
        if(!blue_end){
            for(int i = 0; i < 4; i++){
                int nx = arx[i] + bx;
                int ny = ary[i] + by;
                if(validation(nx, ny) && map[nx][ny] != 5 && !blue[nx][ny]) b_list.add(new int []{nx, ny});
            }
        }
        else b_list.add(new int []{bx, by});
        
        for(int i = 0; i < r_list.size(); i++){
            int [] r_arr = r_list.get(i);
            for(int j = 0; j < b_list.size(); j++){
                int [] b_arr = b_list.get(j);
                // 서로 같은 위치로 이동 X
                if(r_arr[0] == b_arr[0] && r_arr[1] == b_arr[1]) continue;
                // 서로 자리 바꾸기 X
                if(rx == b_arr[0] && ry == b_arr[1] && bx == r_arr[0] && by == r_arr[1]) continue; 
                
                red[r_arr[0]][r_arr[1]] = true;
                blue[b_arr[0]][b_arr[1]] = true;
                move(r_arr[0], r_arr[1], b_arr[0], b_arr[1], move + 1, red_end, blue_end);
                red[r_arr[0]][r_arr[1]] = false;
                blue[b_arr[0]][b_arr[1]] = false;
            }
        }
    }
    public static boolean validation(int nx, int ny){ // ArrayOutOfBoundsIndex 예외 방지 
        if(0 <= nx && 0 <= ny && nx < a && ny < b) return true;
        return false;
    }
}