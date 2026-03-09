import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    

    public static void main(String[] args) throws Exception {
        
        int N = Integer.parseInt(br.readLine());
    
        st = new StringTokenizer(br.readLine());
        int[] fruits = new int[N];
        for(int i = 0; i < N; i++){
            fruits[i] = Integer.parseInt(st.nextToken());
        }
    
        int[] count = new int[10];
        int left = 0;
        int kind = 0;
        int answer = 0; 

        for(int right = 0; right < N; right++){
            int fruit = fruits[right];
            if(count[fruit] == 0){
                kind++;
            }
            count[fruit]++;
            while(kind > 2){
                int leftFruit = fruits[left];
                count[leftFruit]--;
                if(count[leftFruit] == 0){
                    kind--;
                }
                left++;
            }
            answer = Math.max(answer, right-left+1);
        }

        System.out.print(answer);
    }
}