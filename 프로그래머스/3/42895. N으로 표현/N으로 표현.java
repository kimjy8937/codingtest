import java.util.*;

class Solution {
    static List<Set<Integer>> dp = new ArrayList<>();
    public int solution(int N, int number) {
        
        for(int i=0;i<=8;i++)
        {
            dp.add(new HashSet<>()); 
        }
        
        dp.get(1).add(N);
        
        for(int i=2;i<=8;i++)
        { 
            Set<Integer> storeTemp = dp.get(i); 
            for(int j=1;j<i;j++) 
            {
                Set<Integer> numsJ = dp.get(j);
                Set<Integer> numsIminusJ = dp.get(i-j);
                for(int num1 : numsJ)
                {
                    for(int num2 : numsIminusJ)
                    {
                        storeTemp.add(num1 * num2);
                        storeTemp.add(num1 - num2);
                        storeTemp.add(num1 + num2);
                        if(num1 != 0 && num2 != 0)
                        {
                            storeTemp.add(num1 / num2);
                        }
                        storeTemp.add(Integer.parseInt(String.valueOf(N).repeat(i)));
                    }
      
                }
            
                
            }
            
            
        }
        
        for(int i=1;i<=8;i++)
        {
            if(dp.get(i).contains(number))
            {
                return i;
            }
        }       
        return -1;   
    }
}