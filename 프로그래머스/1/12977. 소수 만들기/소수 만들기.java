class Solution {    
    public int solution(int[] nums) {
        int answer = 0;

        for(int i = 0; i < nums.length - 2; i++) {
            for(int j = i+1; j < nums.length - 1; j++) {
                for(int k = j+1; k < nums.length; k++) {
                    if(isPrime(nums, i, j, k)) answer++;
                }
            }
        }
        return answer;
    }
    
    public static boolean isPrime(int[] nums,  int i, int j, int k) {
        boolean flag = false;
        //한 숫자로라도 나눠떨어지는지
        int sum = nums[i] + nums[j] + nums[k];

        for(int a = 2; a < sum; a++) {
            if(sum % a == 0) {
                flag = true;
            }
        }
        return !flag;
    }
}
