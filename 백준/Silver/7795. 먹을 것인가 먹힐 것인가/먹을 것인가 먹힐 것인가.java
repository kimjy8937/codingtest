import java.io.*;
import java.util.*;

public class Main {
    static int T, N, M, answer;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            answer = 0;
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            arr = new int[N];
            M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                int key = Integer.parseInt(st.nextToken());
                answer += binarySearch(key);
            }

            System.out.println(answer);
        }

    }
    static int binarySearch(int key) {
        int left = 0;
        int right = N - 1;
        while (left <= right) { 
            int mid = (left + right) / 2;
            if (key >= arr[mid]) { 
                left = mid + 1;
            } else if (key < arr[mid]) { 
                right = mid - 1;
            }
        }
        return N - right - 1; 
    }
}