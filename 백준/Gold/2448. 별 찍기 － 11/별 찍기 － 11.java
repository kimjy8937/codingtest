import java.io.*;
import java.util.*;

public class Main {
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        arr = new char[n][n + n - 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(arr[i], ' ');
        }

        recursion(0, 0, n);


        for (char[] stars : arr) {
            sb.append(stars).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }


    private static void recursion(int r, int c, int div) {

        if (div == 3) {
            arr[r][c + 2] = '*';
            arr[r + 1][c + 1] = arr[r + 1][c + 3] = arr[r + 2][c] = arr[r + 2][c + 1] = arr[r + 2][c + 2] = arr[r + 2][c + 3] = arr[r + 2][c + 4] = '*';

        }else {
            int mid = div / 2 ;

   
            recursion(r, c + mid, mid);
            recursion(r + mid, c, mid);
            recursion(r + mid , c + div , mid);
        }
    }


}