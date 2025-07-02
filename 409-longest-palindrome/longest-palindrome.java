import java.util.*;

public class Solution {
    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();
        int count = 0;

        for (char ch : s.toCharArray()) {
            if (set.contains(ch)) {
                set.remove(ch);
                count += 2;
            } else {
                set.add(ch);
            }
        }
        if (!set.isEmpty()) {
            count += 1;
        }

        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String input = "abccccdd";
        int result = sol.longestPalindrome(input);
        System.out.println("Longest palindrome length = " + result); 
    }
}
