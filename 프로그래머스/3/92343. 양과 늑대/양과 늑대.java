import java.util.*;
class Solution {
    static List<Integer>[] tree;
    static int ans = 0;
    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        tree = new ArrayList[info.length];
        
        for(int i=0; i<info.length; i++) tree[i] = new ArrayList<>();
        for(int[] arr : edges) tree[arr[0]].add(arr[1]);
        
        List<Integer> next = new ArrayList<>();
        next.add(0);
        bt(0,0,0, next, info);
                
        return ans;
    }
    
    public void bt(int cur, int sheep, int wolf, List<Integer> next, int[] info) {
        if(info[cur] == 0) {
            sheep++;
        } else {
            wolf++;
        }
        
        if(wolf >= sheep) return;
        ans = Math.max(ans, sheep);
        
        List<Integer> list = new ArrayList<>(next);
        list.remove(Integer.valueOf(cur));
        list.addAll(tree[cur]);
        
        for(int n : list) {
            bt(n, sheep, wolf, list, info);
        }
    }
}