import java.io.*;
import java.util.*;

public class Main{
    static int white = 0;
    static int blue = 0;
    static int[][] board;
    
    static void partition(int row, int col, int size){
        boolean flag = true;
        
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(board[row][col] != board[row+i][col+j]) {
                    flag = false;
                    break;
                }
                if(!flag) break;
            }
        }
        
        if(flag) {
            if(board[row][col] == 0){
                white++;
            }else {
                blue++;
            }
        }else {
            partition(row, col, size / 2);
            partition(row + size/2, col, size / 2);
            partition(row, col + size/2, size/2);
            partition(row + size/2, col + size/2, size/2);
        } 
    }
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        
        StringTokenizer st;
        
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            
            for(int j = 0; j < N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        partition(0, 0, N);
        
        System.out.println(white);
        System.out.println(blue);
    }
}