import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> nameSet = new HashSet<>();
        List<String> result = new ArrayList<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < N+M; i++){
            String name = br.readLine();
            if(nameSet.contains(name)){
                result.add(name);
            }
            nameSet.add(name);
        }
        
        Collections.sort(result);
        for(String name : result){
            sb.append(name).append('\n');
        }
        
        System.out.println(result.size());
        System.out.println(sb.toString());
    }
}