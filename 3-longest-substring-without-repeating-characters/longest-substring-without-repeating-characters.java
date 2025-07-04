class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> window = new HashSet<>();
        int left = 0, right = 0, maxLength = 0;

        while (right < s.length()) {
            char current = s.charAt(right);
            
            while (window.contains(current)) {
                window.remove(s.charAt(left));
                left++;
            }

            window.add(current);

            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }
}
