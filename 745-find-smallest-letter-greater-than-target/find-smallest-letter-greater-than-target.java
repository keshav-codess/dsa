class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (letters[mid] <= target) {
                left = mid + 1;  // go to the right
            } else {
                right = mid - 1; // go to the left
            }
        }

        return letters[left % letters.length];
    }
}
