import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[8];
        for(int i = 0; i < 8; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        if(arr[0] == 1){
            for(int i = 1; i < 8; i++){
                if(arr[i-1] >= arr[i]){
                    System.out.println("mixed");
                    return;
                }
            }
            System.out.println("ascending");
        }else if(arr[0] == 8){
            for(int i = 1; i < 8; i++){
                if(arr[i-1] <= arr[i]){
                    System.out.println("mixed");
                    return;
                }
            }
            System.out.println("descending");
        }else{
            System.out.println("mixed");
        }
    }
}