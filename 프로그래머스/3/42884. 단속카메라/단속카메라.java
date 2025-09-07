import java.util.*;

class Solution {
    public int solution(int[][] routes) {

        Arrays.sort(routes, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return a[1]-b[1];
            }
        });

        int count = 1;
        int num = routes[0][1];
        for(int i=1; i<routes.length; i++){

            int[] now = routes[i];
           
            if(now[0]<=num && num<=now[1]){
                continue;
            
            } else {
                
                count++; 
                num = now[1];
            }
        }
        
        return count;
    }
}