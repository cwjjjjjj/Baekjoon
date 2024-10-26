import java.io.*;
import java.util.*;

class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        int ab = Integer.parseInt(String.valueOf(a) + String.valueOf(b));
        int ba = Integer.parseInt(String.valueOf(b) + String.valueOf(a));
        
        if (ab > ba) {
            answer = ab;
        } else if (ba > ab) {
            answer = ba;
        } else {
            answer = ab;
        }

        return answer;
    }
}