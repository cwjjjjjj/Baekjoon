import java.util.*;
import java.io.*;

class Solution {
    public List<Integer> solution(String my_string) {
        List<Integer> nums = new ArrayList<>();
        String[] charArr = my_string.split("");
        for(String c : charArr) {
            try {
                nums.add(Integer.parseInt(c));
            } catch (Exception e)  {
              continue;
            }
        }
        
        Collections.sort(nums);
        return nums;
    }
}