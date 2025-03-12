import java.util.*;
import java.io.*;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        int count = 0;
        n = Integer.parseInt(br.readLine());
       

        if(n % 5 == 0){
            System.out.println(n/5);
            return;
        }

        while(n >= 0){
            if(n == 0){
                System.out.println(count);
                return;
            }
            if(n % 5 == 0){
                count += (n / 5);
                break;
            }
            n -= 3;
            count++;
        }
        
        int answer = n < 0 ? -1 : count;
        System.out.println(answer);
    }
}
