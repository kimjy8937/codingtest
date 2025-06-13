import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] numArr = new int[10];
        int maxNum = 0;
        
        int N = Integer.parseInt(br.readLine());
        
        while(N > 0){
            int t = N % 10;
            if(t == 9)
                numArr[6] += 1;
            else
                numArr[t] += 1;
            N /= 10;
        }
        numArr[6] = (numArr[6] + 1) / 2;

        
        for(int i = 0; i < 10; i++){
            maxNum = Math.max(maxNum, numArr[i]);
        }
        
        bw.write(String.valueOf(maxNum));
        bw.flush();
    }
}