import java.util.*;
import java.io.*;

public class Main{
    static class Node{
        int x, y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Node> list = new ArrayList<>();
        
        for(int i = 0; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Node(x, y));
        }
        
        Collections.sort(list, (a, b) -> {
            if(a.y == b.y){
                return a.x - b.x;
            }
            return a.y - b.y;
        });
        
        StringBuilder sb = new StringBuilder();
        for(Node n : list){
            sb.append(n.x).append(' ').append(n.y).append('\n');
        }
        System.out.println(sb.toString());
    }
}