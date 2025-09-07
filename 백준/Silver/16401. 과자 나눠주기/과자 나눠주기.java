import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        String[] line = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }

        Arrays.sort(arr); // 과자 길이 오름차순 정렬

        int answer = 0;
        int left = 1;
        int right = arr[N-1];
        while(left <= right) {
            int mid = (left + right) / 2;

            int cnt = 0;
            for(int i=N-1; i>=0; i--) {
                if(arr[i] < mid) {
                    break;
                }
                cnt += arr[i] / mid;
            }

            if(cnt >= M) { // M명 이상에게 나눌 수 있다면
                answer = Math.max(answer, mid);
                left = mid + 1;
            } else { // M명에게 나누어 줄 수 없을 때
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }
}