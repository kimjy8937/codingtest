import java.io.*;
import java.util.*;

public class Main{
    static int[][] board;
    static StringBuilder sb;
    
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
                sb.append('0');
            }else {
                sb.append('1');
            }
        }else {
            sb.append('(');
            partition(row, col, size / 2);
            partition(row, col + size/2, size/2);
            partition(row + size/2, col, size / 2);
            partition(row + size/2, col + size/2, size/2);
            sb.append(')');
        } 
    }
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        
        sb = new StringBuilder();
        
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            
            for(int j = 0; j < N; j++){
                board[i][j] = str.charAt(j) - '0';
            }
        }
        
        partition(0, 0, N);
        System.out.println(sb.toString());
    }
}