class Solution {
    public String solution(String phone_number) {
        String answer;
        char[] array = phone_number.toCharArray();
        for(int i = 0; i < phone_number.length()-4; i++) {
            array[i] = '*';
        }
        answer = new String(array);
        return answer;
    }
}