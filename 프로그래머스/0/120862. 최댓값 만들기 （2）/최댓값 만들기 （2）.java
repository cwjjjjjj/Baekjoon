import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        Arrays.sort(numbers);
        int len = numbers.length;
        return Math.max(numbers[len-1] * numbers[len-2], numbers[0] * numbers[1]);
    }
}