import java.util.*;

class Solution {
    boolean[] used;
    ArrayList<String> route = new ArrayList<>();
    String[] answer;
    
    
    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) return a[1].compareTo(b[1]);
            return a[0].compareTo(b[0]);
        });
        used = new boolean[tickets.length];
        route.add("ICN");
        dfs("ICN", tickets, 0);
        return answer;
    }
    
    boolean dfs(String current, String[][] tickets, int count) {
        if(count == tickets.length) {
            answer = route.toArray(new String[0]);
            return true;
        }
        
        for(int i = 0; i < tickets.length; i++) {
            if(!used[i] && tickets[i][0].equals(current)) {
                used[i] = true;
                route.add(tickets[i][1]);
                
                if (dfs(tickets[i][1], tickets, count + 1)) {
                    return true;
                }

                route.remove(route.size() - 1);
                used[i] = false;
            }
        }
        return false;
    }
}