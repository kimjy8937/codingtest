import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int[] num;
        StringTokenizer st;
        for(int i=0;i<T;i++){
            int N = Integer.parseInt(br.readLine());
            long answer = 0;
            st = new StringTokenizer(br.readLine()," ");
            num = new int[N];
            for(int j=0;j<N;j++)
                num[j] = Integer.parseInt(st.nextToken());
            int max = num[N-1];	
            for(int j=N-2;j>=0;j--) {
                if(num[j] <= max)	
                    answer += max - num[j];
                else	
                    max = num[j];
            }
            bw.write(answer + "\n");	
        }
        bw.flush();
        bw.close();
        br.close();
    }
}