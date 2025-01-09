import java.io.*;
import java.util.*;

class Solution {
    public String solution(String my_string) {
        String answer = "";
        StringBuilder sb = new StringBuilder(my_string);
        return sb.reverse().toString();
    }
}