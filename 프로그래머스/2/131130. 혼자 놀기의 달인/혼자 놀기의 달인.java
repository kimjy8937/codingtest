import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int N = cards.length;
        boolean visited[] = new boolean [N];
        List<Integer>result = new ArrayList<>();
        for(int i=0;i<N;i++){
            Queue<Integer>queue = new LinkedList<>();
            if(!visited[cards[i]-1]){
                int cnt = 0;
                queue.add(cards[i]-1);
                visited[cards[i]-1] = true;
                while(!queue.isEmpty()){
                    int now = queue.poll();
                    cnt++;
                    int next = cards[now]-1;
                    if(visited[next]) continue;
                    queue.add(next);
                    visited[next]=true;
                }
                result.add(cnt);
                
            }
            
        }
        for(int s : result)
            System.out.println(s);
        Collections.sort(result,Comparator.reverseOrder());
        int answer = 0;
        if(result.size()!=1)
            answer = result.get(0)*result.get(1);
        return answer;
    }
}