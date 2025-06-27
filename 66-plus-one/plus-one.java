class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        
        for ( int i = n-1; i >= 0; i--){
            if ( digits[i] < 9 ){ //simply adds 1
            digits[i]++;
            return digits;
            }
            digits[i] = 0; // for greater than 9
        }

        int[] result = new int[n+1]; // if all digits 9
        result[0]=1;
        return result;
        
        
    }
}