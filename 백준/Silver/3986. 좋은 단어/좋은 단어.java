import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        
        
        for(int i = 0; i < N; i++){
            ArrayDeque<Character> stk = new ArrayDeque<>();
            String word = br.readLine();
            char[] cArr = word.toCharArray();
            
            for(int j = 0; j < cArr.length; j++){
                if(stk.isEmpty()){
                    stk.push(cArr[j]);
                }else{
                    if(stk.peek() == cArr[j])
                        stk.pop();
                    else
                        stk.push(cArr[j]);
                }
            }
            if(stk.isEmpty())
                count++;
        }
        System.out.println(count);
    }
}