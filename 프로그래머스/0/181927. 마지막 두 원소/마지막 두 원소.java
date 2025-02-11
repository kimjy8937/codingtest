import java.util.Arrays;
class Solution {
    public int[] solution(int[] num_list) {
        int[] newArray = {};
        int last_index = num_list.length - 1;
        if(num_list[last_index] > num_list[last_index-1]){
            newArray = Arrays.copyOf(num_list, num_list.length+1);
            newArray[newArray.length-1] = num_list[last_index] - num_list[last_index-1];
        }else{
            newArray = Arrays.copyOf(num_list, num_list.length+1);
            newArray[newArray.length-1] = 2 * num_list[last_index];
        }
        return newArray;
    }
}