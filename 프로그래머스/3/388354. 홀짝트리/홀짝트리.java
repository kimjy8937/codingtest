import java.util.*;

class ExploreResult {
    int oddNode;
    int evenNode;
    int reverseOddNode;
    int reverseEvenNode;

    public int getReverseOddEvenTree() {
        if((reverseOddNode == 1 && reverseEvenNode == 0) ||
           (reverseOddNode == 0 && reverseEvenNode == 1)
        ) {
            return 1;
        }
        
        return 0;
    }
    
    public int getOddEvenTree() {
        if((oddNode == 1 && evenNode == 0) ||
           (oddNode == 0 && evenNode == 1)
        ) {
            return 1;
        }
        
        return 0;
    }
}
class Solution {
    public int[] solution(int[] nodes, int[][] edges) {
        int[] answer = new int[2];
        
        var tree = initTree(nodes, edges);
        
        Set<Integer> visited = new HashSet<>();
        for(int key : tree.keySet()) {
            if(visited.contains(key)) {
                continue;
            }
            ExploreResult exploreResult = new ExploreResult();
            exploreTree(tree, visited, exploreResult, key);
            answer[0] += exploreResult.getOddEvenTree();
            answer[1] += exploreResult.getReverseOddEvenTree();
            
        }
        return answer;
    }
    
    public void exploreTree(Map<Integer, List<Integer>> tree,
                           Set<Integer> visited,
                           ExploreResult exploreResult,
                           int current
    ) {
        var nexts = tree.get(current);
        if(nexts.size() % 2 == 0 && current % 2 == 0) {
            exploreResult.evenNode++;
        }
        if(nexts.size() % 2 == 1 && current % 2 == 0) {
            exploreResult.reverseEvenNode++;
        }
        if(nexts.size() % 2 == 0 && current % 2 == 1) {
            exploreResult.reverseOddNode++;
        }
        if(nexts.size() % 2 == 1 && current % 2 == 1) {
            exploreResult.oddNode++;
        }
        
        visited.add(current);
        for(int next : nexts) {
            if(visited.contains(next)) {
                continue;
            }
            exploreTree(tree, visited, exploreResult, next);
        }
    }
    
    public Map<Integer, List<Integer>> initTree(int[] nodes, int[][] edges) {
        Map<Integer, List<Integer>> tree = new HashMap<>();
        
        for(int node : nodes) {
            tree.put(node, new ArrayList<>());
        }
        
        for(int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        
        return tree;
    }
}