import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] numArr = new int[10];
        
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        
        int N = A * B * C;
        
        while(N > 0) {
            numArr[N % 10] += 1;
            N /= 10;
        }
        
        for(int i = 0; i < 10; i++) {
            bw.write(String.valueOf(numArr[i]));
            bw.write('\n');
        }
        bw.flush();
    }
}