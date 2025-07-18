import java.util.*;

class Solution {
    public List<Integer> solution(String my_string) {
        List<Integer> nums = new ArrayList<>();
        char[] charArr = my_string.toCharArray();
        for(char c : charArr) {
            if(Character.isDigit(c)){
                nums.add(Character.getNumericValue(c));
            }
        }
        
        Collections.sort(nums);
        return nums;
    }
}