class Solution {
    public int solution(int[] sides) {
        int answer = 1;
        int max = 0;
        int maxIdx = 0;
        
        for (int i = 0; i < 3; i++) {
            if(sides[i] >= max) {
                max = sides[i];
                maxIdx = i;
            }
        }
        
        int sum = 0;
        for(int i = 0; i < 3; i++) {
            if(i != maxIdx) sum += sides[i];
        }
        
        if (max >= sum) {
            answer = 2;
        }
        
        return answer;
    }
}