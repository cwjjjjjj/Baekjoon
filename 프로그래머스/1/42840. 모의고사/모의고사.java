import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] scores = {run(answers, first), run(answers, second), run(answers, third)};
        
        int max = 0;
        for(int i = 0; i < 3; i++) {
            if(max < scores[i]) {
                max = scores[i];
            }
        }
        
        int count = 0;
        for(int i = 0; i < 3; i++) {
            if(max == scores[i]) {
                count++;
            }
        }
        answer = new int[count];
        int index = 0;
        
        for(int i = 0; i < 3; i++) {
            if(max == scores[i]) {
                answer[index++] = i+1;
            }
        }
        return answer;

    } 

    private int run(int[] answers, int[] submit) {
        int score = 0;
        int index = 0;
                
        for (int i = 0; i < answers.length; i++) {
            if(answers[i] == submit[index++]) {
                score++;
            }
            if(index == submit.length) {
                index = 0;
            }
        }
        return score;
    }
}