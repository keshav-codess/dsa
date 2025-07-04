class Solution {

    int search(String pat, String txt) {
        
         int k = pat.length(); 
        int n = txt.length();
        if (n < k) return 0;

        int[] patFreq = new int[26];  // frequency of pat
        int[] windowFreq = new int[26];  // frequency of current window in txt

        for (char ch : pat.toCharArray()) {
            patFreq[ch - 'a']++;
        }

        int count = 0;

        for (int i = 0; i < k; i++) {
            windowFreq[txt.charAt(i) - 'a']++;
        }
        if (Arrays.equals(patFreq, windowFreq)) count++;

        // Slide the window
        for (int i = k; i < n; i++) {
            windowFreq[txt.charAt(i) - 'a']++;               
            windowFreq[txt.charAt(i - k) - 'a']--;          

            if (Arrays.equals(patFreq, windowFreq)) count++;
        }

        return count;
        
    }
}
