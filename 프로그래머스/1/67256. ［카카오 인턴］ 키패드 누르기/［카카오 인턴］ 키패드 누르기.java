class Solution {
    public String solution(int[] numbers, String hand) {
        int[][] locationHands = {{3,0}, {3,2}};
        StringBuilder answer = new StringBuilder();
        int[][] location = {{3,1}, {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1,2}, {2,0}, {2,1}, {2,2}};
        
        for(int i = 0; i < numbers.length; i++){
            
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
                locationHands[0] = location[numbers[i]];
                answer.append('L');
            }else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
                locationHands[1] = location[numbers[i]];
                answer.append('R');
            }else{
                int distanceL = Math.abs((locationHands[0][0] - location[numbers[i]][0])) + Math.abs((locationHands[0][1] - location[numbers[i]][1]));
                int distanceR = Math.abs((locationHands[1][0] - location[numbers[i]][0])) + Math.abs((locationHands[1][1] - location[numbers[i]][1]));

                if(distanceR > distanceL){
                    locationHands[0] = location[numbers[i]];
                    answer.append('L');
                }else if(distanceL > distanceR){
                    locationHands[1] = location[numbers[i]];
                    answer.append('R');
                }else{
                    if(hand.equals("right")){
                        locationHands[1] = location[numbers[i]];
                        answer.append('R');
                    }else if(hand.equals("left")){
                        locationHands[0] = location[numbers[i]];
                        answer.append('L');
                    }
                }   
            }  
        }
        return answer.toString();
    }
}