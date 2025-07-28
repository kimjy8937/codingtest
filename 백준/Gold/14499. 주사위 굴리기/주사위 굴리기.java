import java.io.*;
import java.util.*;
 
public class Main {
    
    static int N, M, x, y, K, map[][], commands[];
    static int[] dr = {0, 0, 0, -1, 1}, dc = {0, 1, -1, 0, 0}; // 동서북남
    static int[] dice;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken()); 
        x = Integer.parseInt(st.nextToken()); 
        y = Integer.parseInt(st.nextToken()); 
        K = Integer.parseInt(st.nextToken()); 
        
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()); 
            }
        }
        
        commands = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            commands[i] = Integer.parseInt(st.nextToken());
        }
        
        dice = new int[7];
        System.out.println(process());
    }
 
    private static StringBuilder process() {
 
        StringBuilder sb = new StringBuilder();
        
        int res = 0;
        for (int i = 0; i < K; i++) {
            res = command(commands[i]);
            // 주사위가 바깥으로 이동할 경우
            if(res == -1) continue;
            sb.append(res + "\n");
        }
        
        return sb;
    }
 
    private static int command(int dir) {
 
        // 주사위를 굴리고
        x += dr[dir];
        y += dc[dir];
 
        // 주사위가 바깥으로 나갈 경우 
        if(x < 0 || y < 0 || x >= N || y >=M) {
            x -= dr[dir];
            y -= dc[dir];
            
            return -1;
        }
        
        // 주사위 위치의 변화
        int[] tmpDice = new int[7];        
        for (int i = 0; i < 7; i++) {
            tmpDice[i] = dice[i];
        }
        switch(dir) {
        case 1: // 동
            dice[1] = tmpDice[4];
            dice[3] = tmpDice[1];
            dice[4] = tmpDice[6];
            dice[6] = tmpDice[3];
            break;
        case 2: // 서
            dice[1] = tmpDice[3];
            dice[3] = tmpDice[6];
            dice[4] = tmpDice[1];
            dice[6] = tmpDice[4];
            break;
        case 3: // 북
            dice[1] = tmpDice[5];
            dice[2] = tmpDice[1];
            dice[5] = tmpDice[6];
            dice[6] = tmpDice[2];
            break;
        case 4: // 남
            dice[1] = tmpDice[2];
            dice[2] = tmpDice[6];
            dice[5] = tmpDice[1];
            dice[6] = tmpDice[5];
            break;
        }
        
        // 이동한 칸에 쓰여 있는 수가 0이면, 주사위의 바닥면에 쓰여 있는 수가 칸에 복사 
        if(map[x][y] == 0) map[x][y] = dice[6];
        // 0이 아닌 경우에는 칸에 쓰여 있는 수가 주사위의 바닥면으로 복사되며, 칸에 쓰여 있는 수는 0
        else {
            dice[6] = map[x][y];
            map[x][y] = 0;
        }
        
        return dice[1];
    }
    
}
