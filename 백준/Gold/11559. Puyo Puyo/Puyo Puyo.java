import java.io.*;
import java.util.*;
 
public class Main {
    private static char[][] field = new char[12][6];
    public static void main(String[] args) throws Exception{
 
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
 
        //필드 초기화
        for (int i = 0; i < 12; i++) {
            field[i] = br.readLine().toCharArray();
        }
 
        boolean tmp = true;
        int result = 0;
        while(tmp) { // 연쇄가 더 이상 일어나지 않을 때까지 반복
            tmp = pop(); // 뿌요를 터트리고
            if(tmp) { // 연쇄가 일어났다면
                drop(); // 떠있는 뿌요들을 밑으로 떨어뜨려줌
                result++;
            }
        }
 
        // 몇연쇄인지 출력
        System.out.println(result);
    }
 
    private static boolean pop() { // 연쇄가 일어났다면 true, 일어나지 않았다면 false
 
        boolean ret = false;
 
        boolean[][] visited = new boolean[12][6];
 
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                if(!visited[i][j]) {
                    // 빈 칸일 경우
                    if(field[i][j]== '.') visited[i][j] = true;
                    else { // 뿌요일 경우
                        Queue<int[]> pps = bfs(visited, i, j); // bfs로 인접한 같은 뿌요들 리스트 가져오기
                        if(pps.size() >= 4) { // 인접한 같은 뿌요들이 4개 이상이라면
                            int[] now;
                            while(!pps.isEmpty()) {
                                now = pps.poll();
                                field[now[0]][now[1]] = '.'; // 터트려준다.
                            }
                            ret = true; // 연쇄가 일어났다고 표시
                        }
                    }
                }
            }
        }
 
        return ret;
    }
 
    private static Queue<int[]> bfs(boolean[][] visited, int x, int y) {
 
        // 사방탐색
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
 
        // 시작점의 문자열 종류
        char c = field[x][y];
 
        // 시작점 방문체크
        visited[x][y] = true;
 
        // 사방 탐색을 위한 큐
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x, y});
 
        // 뿌요가 터질 경우를 위한 큐
        Queue<int[]> ret = new LinkedList<>(); // (x, y)와 같은 색의 인접한 뿌요 좌표를 담아둠
        ret.add(new int[] {x, y});
 
        int[] now;
        while(!q.isEmpty()) {
            now = q.poll();
 
            int nx, ny;
            for (int i = 0; i < 4; i++) {
                nx = now[0] + dx[i];
                ny = now[1] + dy[i];
                if(nx >= 0 && nx < 12 && ny >= 0 && ny < 6) { // 범위 체크
                    if(!visited[nx][ny] && field[nx][ny] == c) { // 아직 방문 전이고, 시작 뿌요와 같다면
                        visited[nx][ny] = true;
                        q.add(new int[] {nx, ny});
                        ret.add(new int[] {nx, ny});
                    }
                }
            }
        }
 
        return ret; // 시작 뿌요와 인접해 있는 같은 뿌요들의 좌표값이 들어있는 큐 반환
    }
 
    private static void drop() { // 연쇄가 일어난 뿌요들을 투 포인터를 사용하여 밑으로 떨어뜨리는 메소드
 
        /**
         * 세로 줄들을 확인
         * e는 가장 밑에 있는 빈 칸을 가리킴
         * s는 한 칸씩 위로 올라가면서 공중에 있는 뿌요가 있다면 가리킴
         */
        for (int i = 0; i < 6; i++) {
            int s = -1, e = -1;
            // 가장 밑에 있는 빈 칸 구하기
            int tmp = 11;
            while(tmp > 0) {
                if(field[tmp][i] == '.') {
                    s = tmp; e = tmp;
                    break;
                }
                tmp--;
            }
 
            while(s >= 0) {
                if(field[s][i] != '.') { // 위에 떠있는 뿌요를 발견했다면
                    field[e--][i] = field[s][i]; // 밑에 넣어줌
                }
                s--;
            }
 
            // 위에 남은 쓰레기 정보들을 모두 지워줌.
            while(e >= 0) {
                field[e--][i] = '.';
            }
        }
    }
}