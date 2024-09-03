import java.io.*;
import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = -1;
        long res = 0;
        long num = 1;
        while(res <= n) {
            res = num * num;;
            if(res == n) {
                answer = (num+1)*(num+1);
                break;
            } else {
                num++;
            }
        }
        return answer;
    }
}