import java.util.*;
import java.io.*;

class Solution {
    public LinkedList<Integer> solution(int[] arr, int divisor) {
        // int[] answer = {};
        LinkedList<Integer> answer = new LinkedList<>();
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] % divisor == 0) {
                answer.add(arr[i]);
            }
        }
        
        if(answer.isEmpty()) {
            answer.add(-1);
        }
        return answer;
    }
}