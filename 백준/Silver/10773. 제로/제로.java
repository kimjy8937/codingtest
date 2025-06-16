import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int K = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> stk = new ArrayDeque<>();
        int answer = 0;
        
        for(int i = 0; i < K; i++){
            int n = Integer.parseInt(br.readLine());
            if(n > 0){
                stk.push(n);
            }else if(n == 0){
                stk.pop();
            }
        }
        
        while(!stk.isEmpty()){
            answer += stk.pop();
        }
        
        bw.write(String.valueOf(answer));
        bw.flush();
    }
}