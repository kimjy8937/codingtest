import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int answer = 0;
        
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(br.readLine());
        
        int[] numArr = new int[n];
        for(int i = 0; i<n; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i = 0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(numArr[i] + numArr[j] == x){
                    answer++;
                    break;
                }
            }
        }
        bw.write(String.valueOf(answer));
        bw.flush();
    }
    
}