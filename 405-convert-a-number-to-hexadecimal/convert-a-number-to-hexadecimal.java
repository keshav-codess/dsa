class Solution {
    public String toHex(int num) {
        if (num == 0) return "0";

        char[] hexChars = "0123456789abcdef".toCharArray();
        StringBuilder sb = new StringBuilder();

        while (num != 0) {
            int last4Bits = num & 0xf;  // last 4 bits
            sb.append(hexChars[last4Bits]);
            num >>>= 4;  // right shift by 4
        }

        return sb.reverse().toString();
    }
}
