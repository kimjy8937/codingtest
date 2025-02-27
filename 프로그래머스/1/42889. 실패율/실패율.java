import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] challenger = new int[N];
        int[] loser = new int[N];
        double[][] loseRate = new double[N][2];
        
        Arrays.fill(challenger, 0);
        Arrays.fill(loser, 0);
        
        for(int i = 0; i < stages.length; i++){
            if(stages[i] <= N)
                loser[stages[i]-1] +=1;
            
            for(int j = 1; j <= stages[i]; j++){
                if(j <= N)
                    challenger[j-1] += 1;     
            }
        }
        
        for(int i = 0; i < loseRate.length; i++){
            loseRate[i][0] = i+1;
            loseRate[i][1] = challenger[i] == 0 ? 0.0 : (double)loser[i]/challenger[i];
        }
        
        
        Arrays.sort(loseRate, new Comparator<double[]>() {
            @Override
            public int compare(double[] a, double[] b) {
                return Double.compare(b[1], a[1]);
            }
        });
        for(int i = 0; i< loseRate.length; i++){
            System.out.print(loseRate[i][1]);
        }
        
        for(int i = 0; i < N; i++){
            answer[i] = (int)loseRate[i][0];
        }
        
        
        return answer;
    }
}