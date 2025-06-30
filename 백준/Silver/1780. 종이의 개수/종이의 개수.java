import java.io.*;
import java.util.*;

public class Main {
    public static int minus =0;
    public static int zero =0;
    public static int plus =0;
    public static int[][] paper;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        for(int i=0; i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N;j++){
                paper[i][j]= Integer.parseInt(st.nextToken());
            }
        }
        divide(0,0,N);
        System.out.println(minus);
        System.out.println(zero);
        System.out.println(plus);
    }

    public static void divide(int row,int col,int size){
        if (check(row, col, size)) {
            if(paper[row][col]==-1){
                minus++;
            }else if(paper[row][col]==0){
                zero++;
            }else{
                plus++;
            }
            return;
        }
        int[] move = {0,1,2};
        int newSize= size/3;
        for(int i=0; i<3;i++){
            for(int j=0; j<3;j++){
                divide(row+(i*newSize),col+(j*newSize),newSize);
            }
        }
    }
    public static boolean check(int row,int col,int size){
        int pivot = paper[row][col];
        for(int i=row; i<row+size;i++){
            for(int j=col;j<col+size;j++){
                if(paper[i][j]!=pivot){
                    return false;
                }
            }
        }
        return true;
    }
}