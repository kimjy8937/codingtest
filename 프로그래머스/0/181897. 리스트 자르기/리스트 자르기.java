import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        List<Integer> al = new ArrayList<Integer>();
        int[] answer = {};
        switch(n){
            case 1:
                return Arrays.copyOfRange(num_list, 0, slicer[1]+1);
            case 2:
                return Arrays.copyOfRange(num_list, slicer[0], num_list.length);
            case 3:
                return Arrays.copyOfRange(num_list, slicer[0], slicer[1]+1);
            case 4:  
                for(int i = slicer[0]; i < slicer[1]+1 ; i+=slicer[2]){
                    al.add(num_list[i]);
                }
                answer = al.stream().mapToInt(i -> i).toArray();
                break;
        }
        return answer;
    }
}