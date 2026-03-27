import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int count = 0;
        int num = 666;
        while(true){
            if(String.valueOf(num).contains("666")){
                count++;
                if(count == N){
                    System.out.println(num);
                    return;
                }
            }
            num++;
        }
    }
}