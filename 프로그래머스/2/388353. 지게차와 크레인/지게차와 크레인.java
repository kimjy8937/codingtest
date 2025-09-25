import java.util.*;
class Solution {
    static final int INF = 10001;
    static int [] arx = {-1,1,0,0};
    static int [] ary = {0,0,-1,1};
    static int n, m;
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        n = storage.length;       // 행
        m = storage[0].length();  // 열
        int [][] map = new int [n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                map[i][j] = storage[i].charAt(j) - 'A';
            }
        }
        // 요청 처리 
        for(String request : requests){
            int target = request.charAt(0) - 'A';
            // 크레인 로직 
            if(request.length() == 2){
                for(int i = 0; i < n; i++){
                    for(int j = 0; j < m; j++){
                        if(map[i][j] == target){
                            map[i][j] = -1;
                        }
                    }
                }
                continue;
            }
            // 지게차 로직
            int [][] memo = new int [n][m];
            for(int i = 0; i < n; i++){
                Arrays.fill(memo[i], INF);
            }
            ArrayList<int[]> list = new ArrayList<>();
            Queue<int[]> q = new LinkedList<>();
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(i != 0 && j != 0 && i != n - 1 && j != m - 1) continue;
                    if(memo[i][j] != INF) continue;
                    if(map[i][j] != -1){
                        memo[i][j] = 1;
                        if(map[i][j] == target){
                            list.add(new int []{i,j});
                        }
                        continue;
                    }
                    memo[i][j] = 0;
                    q.add(new int [] {i, j});
                    while(!q.isEmpty()){
                        int [] cur = q.poll();
                        for(int k = 0; k < 4; k++){
                            int nx = cur[0] + arx[k];
                            int ny = cur[1] + ary[k];
                            if(!validation(nx, ny) || memo[nx][ny] != INF) continue;
                            if(map[nx][ny] == -1){
                                memo[nx][ny] = 0;
                                q.add(new int [] {nx, ny});
                                continue;
                            }
                            memo[nx][ny] = 1;
                            if(map[nx][ny] == target){
                                list.add(new int []{nx,ny});
                            }
                        }
                    }
                }
            }   
            // 이번 요청에서 제거 대상인 컨테이너 제거 
            for(int [] next : list){
                map[next[0]][next[1]] = -1;
            }
        }
        
        // 남은 컨테이너 개수 count
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] != -1) answer++;
            }
        }
        return answer;
    }
    
    // Arrays out of index 방지 
    public static boolean validation(int nx, int ny){
        if(0 <= nx && 0 <= ny && nx < n && ny < m) return true;
        return false;
    }
}
