class Solution {
    public String solution(String phone_number) {
        String answer;

        //string -> char[] 메서드 !!!!
        char[] array = phone_number.toCharArray();
        for(int i = 0; i < phone_number.length()-4; i++) {
            array[i] = '*';
        }

        //char[] -> string 생성자 !!!!
        answer = new String(array);
        return answer;
    }
}
