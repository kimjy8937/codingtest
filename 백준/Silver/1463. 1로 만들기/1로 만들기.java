import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dpArr;

    static int dp(int n){
        if(n <= 3) {
            return dpArr[n];
        }
        for(int i = 4; i <= n; i++) {
            if(i % 6 == 0){
                dpArr[i] = Math.min(dpArr[i / 3], dpArr[i / 2]) + 1;
            }
            else if (i % 3 == 0)
                dpArr[i] = Math.min(dpArr[i / 3], dpArr[i - 1]) + 1;
            else if (i % 2 == 0)
                dpArr[i] = Math.min(dpArr[i / 2], dpArr[i - 1]) + 1;
            else{
                dpArr[i] = dpArr[i - 1] + 1;
            }
        }
        return dpArr[n];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dpArr = new int[N+1];
        dpArr[1] = 0;
        if(N >= 2)
            dpArr[2] = 1;
        if(N >= 3)
            dpArr[3] = 1;
        System.out.println(dp(N));
    }
}
