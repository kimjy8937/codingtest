import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        List<Long> list = new ArrayList<>();
        while(st.hasMoreTokens()) {
            list.add(reverse(st.nextToken()));
        }
        String str = "";
        while((str = br.readLine()) != null) {
            st = new StringTokenizer(str);
            while(st.hasMoreTokens()) {
                list.add(reverse(st.nextToken()));
            }
        }

        Collections.sort(list);
        for (int i = 0; i < N; i++) {
            sb.append(list.get(i)+"\n");
        }
        System.out.println(sb.toString());
    }


    static long reverse(String num) {
        StringBuilder sb = new StringBuilder();
        sb.append(num);
        return Long.parseLong(sb.reverse().toString());
    }
}