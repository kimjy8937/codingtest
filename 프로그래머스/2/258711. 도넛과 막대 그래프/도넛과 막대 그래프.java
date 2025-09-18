import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        int e= edges.length;
        int g = 0; // 그래프 개수  ( 생성 정점에서 부터 뻗어나가는 간선 수 )
        // 가장 큰 정점의 번호를 모르니까 map을 사용 
        HashMap<Integer, Integer >toVertex = new HashMap<>(); // 진입
        HashMap<Integer, Integer >fromVertex = new HashMap<>(); // 진출
        HashSet<Integer> set = new HashSet<>(); // 정점 집합 
        for(int i = 0; i<e;i++){
            int a = edges[i][0];
            int b =edges[i][1];
            set.add(a);
            set.add(b);
            if( fromVertex.containsKey(a)){
                fromVertex.put(a, fromVertex.get(a)+1);
            }else{
                 fromVertex.put(a, 1);
            }
            
            if( toVertex.containsKey(b)){
                toVertex.put(b, toVertex.get(b)+1);
            }else{
                 toVertex.put(b, 1);
            }
        }
        
        for (int i: set){
            // 그래프의 개수는 2이상이므로
            // 진출 간선만 있는게 생성 정점임
            if (!toVertex.containsKey(i) && fromVertex.containsKey(i)&& fromVertex.get(i)>=2){
                answer[0]=i; 
            }
            
            // 막대 모양 그래프라면 맨 끝점이 진출간선이 없음
            
            if (!fromVertex.containsKey(i) && toVertex.containsKey(i) ){
                answer[2]++;
            }
            
            // 8 자 모양이라면 진출 , 진입간선 개수가 각 2이상 인게 있어야됨 
              if (fromVertex.containsKey(i) && toVertex.containsKey(i) &&  fromVertex.get(i)>=2 && toVertex.get(i)>=2){
                answer[3]++;
            }
        }
        int num =answer[0];
        for ( int i =0;i<e;i++){
            if (num ==edges[i][0]){
                g++;
            }
        }
        answer[1]= g- answer[2]-answer[3];
        
        return answer;
    }
}