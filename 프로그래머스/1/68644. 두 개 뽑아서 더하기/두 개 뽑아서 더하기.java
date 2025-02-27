import java.util.TreeSet;

class Solution {
    public Integer[] solution(int[] numbers) {
        TreeSet<Integer> ts = new TreeSet<>();
        for(int i = 0; i< numbers.length; i++){
            for(int j = i; j< numbers.length; j++){
                if(i == j)
                    continue;
                ts.add(numbers[i] + numbers[j]);
            }
        }
        
        return ts.toArray(new Integer[0]);
    }
}