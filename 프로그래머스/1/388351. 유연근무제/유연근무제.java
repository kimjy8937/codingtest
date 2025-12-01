class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
     
        for(int i = 0; i<timelogs.length; i++){
            int check = 5;
            for(int j = 0; j<timelogs[i].length; j++){
                int schedule = (schedules[i] / 100 * 60) + (schedules[i] % 100);
                int timelog = (timelogs[i][j] / 100) * 60 + (timelogs[i][j] % 100);
                if(schedule + 10 < timelog){
                    if(startday+j == 6 || startday+j == 7 || startday+j == 13)
                        continue;
                    check -= 1;
                }
                // }else if(schedule >= 2350){
                //     if(timelog < 10 && timelog + 2400 > schedule + 10){
                //         if(startday+j == 6 || startday+j == 7 || startday+j == 13)
                //         continue;
                //     }
                //     check -= 1;
                // }
            }
            if(check == 5)
                answer += 1;
        }
        return answer;
    }
}