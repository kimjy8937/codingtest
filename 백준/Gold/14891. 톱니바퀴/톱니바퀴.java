import java.util.*;
import java.io.*;

public class Main {
    static int[][] chain = new int[4][8];
    static int score = 0;
    static void rotateChain(int n, int d) {
        int[] turnDirs = new int[4];
        turnDirs[n] = d;
        
        for(int i = n; i > 0; i--){
            if(chain[i][6] != chain[i-1][2]) {
                turnDirs[i-1] = turnDirs[i] * (-1);
            }else {
                break;
            }
        }
        for(int i = n; i < 3; i++){
            if(chain[i+1][6] != chain[i][2]) {
                turnDirs[i+1] = turnDirs[i] * (-1);
            }else {
                break;
            }
        }
       
        for(int i = 0; i < turnDirs.length; i++){
            if(turnDirs[i] == 1){
                int tmp = chain[i][7];
                for (int j = 7; j > 0; j--) {
                    chain[i][j] = chain[i][j-1];
                }
                chain[i][0] = tmp;
            }
            else if(turnDirs[i] == -1){
                int tmp = chain[i][0];
                for (int j = 0; j < 7; j++) {
                    chain[i][j] = chain[i][j+1];
                }
                chain[i][7] = tmp;
            }
        }
    }
    
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int i = 0; i < 4; i++){
            String str = br.readLine();
            for(int j = 0; j < 8; j++){
                chain[i][j] = str.charAt(j) - '0';
            }
        }
        int K = Integer.parseInt(br.readLine());
        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            
            rotateChain(n-1, d);
        }
        
        if(chain[0][0] == 1) score += 1;
        if(chain[1][0] == 1) score += 2;
        if(chain[2][0] == 1) score += 4;
        if(chain[3][0] == 1) score += 8;
        
        System.out.println(score);
    }
}