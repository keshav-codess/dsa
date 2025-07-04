import java.util.*;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        
        int[] s1Count = new int[26];
        int[] window = new int[26];
        
        // Count frequency of s1
        for (char c : s1.toCharArray()) {
            s1Count[c - 'a']++;
        }

        // Go through s2 with a sliding window
        for (int i = 0; i < s2.length(); i++) {
            window[s2.charAt(i) - 'a']++; // Add current char
            
            // Shrink window if it becomes too big
            if (i >= s1.length()) {
                window[s2.charAt(i - s1.length()) - 'a']--;
            }

            if (Arrays.equals(s1Count, window)) {
                return true;
            }
        }
        
        return false;
    }
}
