class Solution {
    public int solution(String my_string) {
        int answer = 0;
        for(int i = 0; i < my_string.length(); i++) {
            if(Character.isDigit(my_string.charAt(i))) {
                answer += Character.getNumericValue(my_string.charAt(i));
            }
        }
        return answer;
    }
}