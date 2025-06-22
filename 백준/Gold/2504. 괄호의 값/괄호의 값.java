import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int res = 0;
        
        ArrayDeque<Character> stk = new ArrayDeque<>();
        ArrayDeque<Integer> value = new ArrayDeque<>();
        
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(c == '(' || c == '['){
                stk.push(c);
                value.push(0);
            }else {
                if(stk.isEmpty() || (stk.peek() == '(' && c == ']')
                  || (stk.peek() == '[' && c == ')')){
                    res = 0;
                    break;
                }
                stk.pop();
                int cval = value.pop();
                int mul = c == ')' ? 2 : 3;
                cval = cval == 0 ? 1 : cval;
                if(stk.isEmpty()){
                    res += cval * mul;
                }else{
                    int prev = value.pop();
                    value.push(prev + cval * mul); 
                }
            }
            
        }
        if(!stk.isEmpty())
            res = 0;
        System.out.println(res);
    }
}