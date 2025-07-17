import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine()); 

        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<n; i++) {
            int num = Integer.parseInt(st.nextToken());

            list.add(num);

            if (map1.getOrDefault(num, 0) == 0) {
                map1.put(num, 1);
                map2.put(num, i);
            }
            else {
                map1.put(num, map1.get(num) + 1);
            }

        }

        Collections.sort(list, (o1, o2) -> {
            if (map1.get(o1) == map1.get(o2)) {
                return map2.get(o1) - map2.get(o2);
            }
            else {
                return map1.get(o2) - map1.get(o1);
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            sb.append(list.get(i) + " ");
        }
        System.out.println(sb);

    }
}