import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int index = 0;
        
        for (int i = 0; i < commands.length; i++) {
            int[] splitedArray = splitArray(array, commands[i][0], commands[i][1]);
            answer[i] = calculate(splitedArray, commands[i][2]);
        }
        return answer;
    }
    
    private int[] splitArray(int[] array, int st, int end) {
        int[] splitedArray = new int[end-st+1];
        int index = 0;
        
        //st 인덱스에서 하나 빼준 셈 쳤으니까 end 인덱스는 냅둬야 함. 마지막 인덱스가 비어서 0 들어가고 있었음
        for(int i = st; i <= end; i++) {
            splitedArray[index++] = array[i-1];
        }
        
        //배열 출력하는 법을 까먹으면 우뜩함?
        //System.out.println(Arrays.toString(splitedArray));
        return splitedArray;
    }
    
    private int calculate(int[] splitedArray, int k) {
        Arrays.sort(splitedArray);
        return splitedArray[k-1];
    }
}