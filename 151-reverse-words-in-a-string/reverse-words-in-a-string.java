class Solution {
    public String reverseWords(String s) {

        s = s.trim();
        if (s.isEmpty()) return "";

        String[] words = s.split("\\s+");

        int left = 0, right = words.length - 1;
        while (left < right) {
            String tmp = words[left];
            words[left++] = words[right];
            words[right--] = tmp;
        }

        return String.join(" ", words);
    }
}
