import java.io.*;
import java.util.*;

public class Main{
    
   static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   public static void main (String[] args) throws Exception {
       int N = Integer.parseInt(br.readLine());
       
       if(N < 2){
           System.out.print(0);
           return;
       }
       
       boolean[] isPrime = new boolean[N+1];
       
       Arrays.fill(isPrime, true);
       isPrime[0] = false;
       isPrime[1] = false;
       
       for(int i = 2; i * i <= N; i++){
           if(isPrime[i]){
               for(int j = i * i; j <= N; j += i){
                   isPrime[j] = false;
               }
           }
       }
       
       ArrayList<Integer> primes = new ArrayList<>();
       for(int i = 2; i <= N ; i++){
           if(isPrime[i]){
               primes.add(i);
           }
       }
       
       int left = 0;
       int right = 0;
       int sum = 0;
       int count = 0;
       while (true) {
          if (sum >= N) {
              if (sum == N) count++;
                sum -= primes.get(left++);
          } else {
              if (right == primes.size()) break;
              sum += primes.get(right++);
          }
      }
       System.out.print(count);
       return;
   }
}