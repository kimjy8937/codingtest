import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] answer = new int[N];
        for(int i = 0; i < N; i++) {
            int pass = 1;
            int T = Integer.parseInt(br.readLine());
            int[] scores = new int[T+1];
            for(int j = 0; j < T; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int index = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());

                scores[index] = value;
            }
            int tmp = scores[1];

            for(int j=2 ; j <= T ; j++){
                if(scores[j] < tmp){
                    tmp = scores[j];
                    pass++;

                }
            }
            answer[i] = pass;
        }

        for(int i = 0; i < N; i++) {
            System.out.println(answer[i]);
        }
    }
}
