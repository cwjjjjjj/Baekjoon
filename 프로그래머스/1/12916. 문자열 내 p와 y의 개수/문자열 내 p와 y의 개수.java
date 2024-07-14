class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        //toLowerCase()는 본래 문자열에 영향 미치지 않음
        String str = s.toLowerCase();
        int p = 0;
        int y = 0;
        for(int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'p') {
                p++;
            } else if (str.charAt(i) == 'y') {
                y++;
            }
        }
        if(p != y) {
            answer = false;
        }
        return answer;
    }
}