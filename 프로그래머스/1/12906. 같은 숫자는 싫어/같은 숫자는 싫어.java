import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        Queue<Integer> queue = new LinkedList<>(); //4
        int lastNum = -1; //4
        
        for(int i = 0; i < arr.length; i++) {
            
            //if(queue.isEmpty() || queue.peek() != arr[i]) -> 이렇게 하면 queue의 제일 앞 원소랑 계속 비교함;;
            if(lastNum != arr[i]) {
                queue.add(arr[i]);
                lastNum = arr[i];
            }
        }
        

        answer = new int[queue.size()];
        int i = 0;
        while(!queue.isEmpty()) {
            answer[i++] = queue.poll();
        }
        
        return answer;
    }
}