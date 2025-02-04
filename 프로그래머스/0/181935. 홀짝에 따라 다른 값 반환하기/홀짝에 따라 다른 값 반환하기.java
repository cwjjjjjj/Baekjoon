import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        if(n % 2 == 1) {
            for(int i = 0; i <= n; i++) {
                if(i % 2 == 1) {
                    answer += i;
                }
            }
        }
        if(n % 2 == 0) {
            for(int i = 0; i <= n; i++) {
                if(i % 2 == 0) {
                    answer += Math.pow(i, 2);
                }
            }
        }
        return answer;
    }
}