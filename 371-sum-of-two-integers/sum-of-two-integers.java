class Solution {
    public int getSum(int a, int b) {
        while (b!=0){
            int carry = ( a & b) << 1;
            a = a ^ b; // for normal addition without carry
            b = carry;
        }
        return a;
    }
}