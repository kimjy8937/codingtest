import java.io.*;
import java.util.*;

public class Main {

    private static List<List<Integer>> graph;
    private static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

        int testCase = Integer.parseInt(stz.nextToken());

        while (testCase-- > 0) {
            stz = new StringTokenizer(br.readLine(), " ");
            int v = Integer.parseInt(stz.nextToken());
            int e = Integer.parseInt(stz.nextToken());

            graph = new ArrayList<>();
            for(int i=0; i<v; i++){
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < e; i++) {
                stz = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(stz.nextToken()) - 1;
                int b = Integer.parseInt(stz.nextToken()) - 1;

                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            boolean isStop = bfs(v);

            if(isStop){
                bw.write("NO");
            }else{
                bw.write("YES");
            }
            bw.write(System.lineSeparator());
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean bfs(int v) {
        Queue<Integer> qu = new LinkedList<>();
        visited = new int[v];

        for(int i=0; i<v; i++){
            if(visited[i] == 0){
                visited[i] = 1;
                qu.add(i);
            }

            while (!qu.isEmpty()){
                int cn = qu.poll();

                for(int d=0; d<graph.get(cn).size(); d++){
                    int nn = graph.get(cn).get(d);

                    if(visited[cn] == visited[nn]){
                        return true;
                    }

                    if(visited[nn] == 0){
                        qu.add(nn);
                        visited[nn] = 3 - visited[cn];
                    }
                }
            }
        }
        return false;
    }
}