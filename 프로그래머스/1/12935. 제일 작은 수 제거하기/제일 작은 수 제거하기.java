import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] arr) {
        //int[] answer = {};
        int len = arr.length;
        //length() 아니고 length!!!!!!
        
        if(len-1==0) {
            int[] answer = {-1};
            return answer;
        }
        
        int[] answer = new int[len-1];
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < len; i++) {
            if(arr[i] < min) {
                min = arr[i];
            }
        }
        
        int j = 0;
        for(int i = 0; i < len; i++) {
            if(arr[i] == min) {
                continue;
            }
            answer[j] = arr[i];
            j++;
        }
        return answer;
    }
}