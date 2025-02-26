import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] answers) {
        ArrayList<Integer> al = new ArrayList<>();
        int maxScore;
        int answerA=0;
        int answerB=0;
        int answerC=0;
        int[] submit = new int[3];
        int[] score = new int[3];
        
        for(int i = 0; i<answers.length; i++){
            submit[0] = (i+1) % 5 == 0 ? 5 : (i+1) % 5;
            
            if(i % 2 == 0)
                submit[1] = 2;
            else if(i % 8 == 1)
                submit[1] = 1;
            else if(i % 8 == 3)
                submit[1] = 3;
            else if(i % 8 == 5)
                submit[1] = 4;
            else if(i % 8 == 7)
                submit[1] = 5;
            
            if(i%10 == 0 || i%10 == 1)
                submit[2] = 3;
            else if(i%10 == 2 || i%10 == 3)
                submit[2] = 1;
            else if(i%10 == 4 || i%10 == 5)
                submit[2] = 2;
            else if(i%10 == 6 || i%10 == 7)
                submit[2] = 4;
            else if(i%10 == 8 || i%10 == 9)
                submit[2] = 5;
            
            for(int j = 0; j < 3; j++)
                if(submit[j] == answers[i])
                    score[j]++; 
        }
        
        maxScore = Math.max(Math.max(score[0], score[1]), score[2]);

        
        for(int i = 0; i < 3; i++)
            if(score[i] == maxScore)
                al.add(i+1);
        
        return al;
    }
}