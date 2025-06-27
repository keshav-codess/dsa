class Solution {
    public int maxConsecBits(int[] arr) {
        // code here
        int count = 0;
        int maxCount = 0;
        int prev = -1;
        
        for ( int num : arr){
            if(num == prev){
                count++;
            }
            
            else {
                count = 1;
                prev = num;
            }
            maxCount = Math.max(count,maxCount);
        }
        return maxCount;
    }
}
