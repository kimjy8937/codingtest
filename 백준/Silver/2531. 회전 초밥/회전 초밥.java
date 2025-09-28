import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int d = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());

    int[] arr = new int[n];
    for(int i = 0;i<n;i++){
      arr[i] = Integer.parseInt(br.readLine());
    }

    HashMap<Integer,Integer> h = new HashMap<>();

    for(int i = 0;i<k;i++){
      h.put(arr[i],h.getOrDefault(arr[i],0)+1);
    }
    h.put(c,h.getOrDefault(c,0)+1);

    int ans = h.size();

    for(int i = 1;i<n;i++){
      if(h.get(arr[i-1]) == 1) h.remove(arr[i-1]);
      else h.put(arr[i-1],h.get(arr[i-1])-1);

      h.put(arr[(i+k-1)%n],h.getOrDefault(arr[(i+k-1)%n],0)+1);

      ans = Math.max(ans,h.size());
    }

    System.out.println(ans);


  }
}