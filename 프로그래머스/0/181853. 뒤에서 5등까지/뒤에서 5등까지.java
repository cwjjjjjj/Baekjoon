import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[5];
        Arrays.sort(num_list);
        int index = 0;
        for(int i = 0; i < 5 ; i++) {
            answer[index++] = num_list[i];
        }
        return answer;
    }
}