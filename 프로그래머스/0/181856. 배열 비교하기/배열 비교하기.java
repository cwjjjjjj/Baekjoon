class Solution {
    public int solution(int[] arr1, int[] arr2) {

        if(arr1.length > arr2.length) {
            return 1;
        }
        
        if(arr1.length < arr2.length) {
            return -1;
        }
        
        int a = 0;
        int b = 0;
        for(int i = 0; i < arr1.length; i++) {
            a += arr1[i];
        }
        for(int i = 0; i < arr2.length; i++) {
            b += arr2[i];
        }
        
        if(a > b) {
            return 1;
        }
        
        if(a < b) {
            return -1;
        }
        
        return 0;
    }
}