class Solution {
    public long[] solution(int x, int n) {
        long[] answer = {};
        answer = new long[n];
        for(int i = 0; i < n;i++) {
            //형변환 꼭 해야 함!!
            answer[i] = (long) x*(i+1);
        }
        return answer;
    }
}
