import java.util.Arrays;
import java.util.List;

class Solution {
    public String solution(int a, int b) {
        String answer = "";
        List<Integer> month31 = Arrays.asList(1, 3, 5, 7, 8, 10, 12);
        List<Integer> month30 = Arrays.asList(4, 6, 9, 11);
        
        for(int i = 1; i < a; i++)
        {
            if(month31.contains(i))
                b += 31;
            else if(month30.contains(i))
                b += 30;
            else
                b += 29;
        }        
        
        switch (b%7){
            case 1:
                return "FRI";
            case 2:
                return "SAT";
            case 3:
                return "SUN";
            case 4:
                return "MON";
            case 5:
                return "TUE";
            case 6:
                return "WED";
            case 0:
                return "THU";
        }
        return answer;
    }
}