class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        List<Character> chars = new ArrayList<>(freqMap.keySet());
        chars.sort((a, b) -> freqMap.get(b) - freqMap.get(a));  // Descending

        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            int freq = freqMap.get(c);
            while (freq-- > 0) {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}