import java.io.*;
import java.util.*;

public class Main {
    public static class Flower implements Comparable<Flower>{
        int start, end;

        public Flower(int start, int end) {
            this.start = start;
            this.end = end;
        }


        @Override
        public int compareTo(Flower o) {
            if(this.start == o.start){
                return o.end - this.end;
            }
            return this.start - o.start;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Flower> pq = new PriorityQueue<>();

        int startValue = 31;
        int endValue = 1130;
        int answer = 0;

        for(int i = 0; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str1 = st.nextToken();
            String str2 = st.nextToken();
            if(str2.length() == 1){
                str2 = 0 + str2;
            }
            String str3 = st.nextToken();
            String str4 = st.nextToken();
            if(str4.length() == 1){
                str4 = 0 + str4;
            }
            int start = Integer.parseInt(str1 + str2);
            int end = Integer.parseInt(str3 + str4);

            if(end <= startValue || start > endValue) continue;

            pq.offer(new Flower(start, end));
        }

        if(pq.size() == 0){
            System.out.println(0);
        }

        int value = 301;

        while(!pq.isEmpty()){
            int max = 0;
            boolean check = false;
            while(!pq.isEmpty()){
                Flower flower = pq.peek();
                if(value >= flower.start){
                    pq.poll();
                    check = true;
                    max = Math.max(max, flower.end);
                }else{
                    break;
                }
            }
            if(!check) break;

            answer++;
            value = max;
            if(value > endValue) break;
        }
        if(value > endValue){
            System.out.println(answer);
        }else{
            System.out.println(0);
        }
    }
}