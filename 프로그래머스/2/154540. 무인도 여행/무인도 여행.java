import java.util.*;

class Solution {
    static int sum=0;
    
    public int[] solution(String[] maps) {
        List<Integer> list = new ArrayList<>();
        
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        
        for(int i=0; i<maps.length; i++) {
        	for(int j=0; j<maps[i].length(); j++) {
        		
                dfs(maps, visited, i, j);
        		if(sum>0) {
        			list.add(sum);
        			sum=0;
        		}
        	}
        }
        
        if(list.size()==0) return new int[] {-1};
        
        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++) {
        	answer[i]=list.get(i);
        }
        
        Arrays.sort(answer);
        return answer;
    }
    
    public void dfs(String[] maps, boolean[][] visited, int i, int j) {
        if(i<0 || j<0 || i>=maps.length || j>=maps[0].length()) return;
        
    	if(maps[i].charAt(j) == 'X' || visited[i][j]) return;
    	else {
    		visited[i][j]=true;
    		sum+=maps[i].charAt(j)-'0';
    	}
        
    	dfs(maps, visited, i+1, j);
    	dfs(maps, visited, i-1, j);
    	dfs(maps, visited, i, j+1);
    	dfs(maps, visited, i, j-1);
    }
}