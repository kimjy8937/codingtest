import java.io.*;
import java.util.*;

public class Main {
    static String[][] star;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        star = new String[N][N];

        print_star(0, 0, N, false);

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                sb.append(star[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }
    static void print_star(int x, int y, int length, boolean blank) {

        if(blank) {
            for(int i = x; i < x + length; i++) {
                for(int j = y; j < y + length; j++) {
                    star[i][j] = " ";
                }
            }
            return;
        }

        if(length <= 1) {
            star[x][y] = "*";
            return;
        }

        int new_length = length / 3;

        int cnt = 0;
        for(int i = x; i < x + length; i += new_length) {
            for(int j = y; j < y + length; j += new_length) {
                cnt++;
                if(cnt == 5) {
                    print_star(i, j, new_length, true);

                }else {
                    print_star(i, j, new_length, false);
                }

            }
        }

    }
}