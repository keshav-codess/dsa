import java.util.*;

class Solution {
    private static final String VOWELS = "aeiou";

    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exact = new HashSet<>();
        Map<String, String> caseInsensitive = new HashMap<>();
        Map<String, String> vowelInsensitive = new HashMap<>();

        for (String word : wordlist) {
            exact.add(word);

            String lower = word.toLowerCase();
            caseInsensitive.putIfAbsent(lower, word);

            String devoweled = devowel(lower);
            vowelInsensitive.putIfAbsent(devoweled, word);
        }

        String[] ans = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];
            if (exact.contains(q)) {
                ans[i] = q;
                continue;
            }

            String lower = q.toLowerCase();
            if (caseInsensitive.containsKey(lower)) {
                ans[i] = caseInsensitive.get(lower);
                continue;
            }

            String devoweled = devowel(lower);
            if (vowelInsensitive.containsKey(devoweled)) {
                ans[i] = vowelInsensitive.get(devoweled);
            } else {
                ans[i] = "";
            }
        }
        return ans;
    }

    private String devowel(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (VOWELS.indexOf(c) >= 0) {
                sb.append('*');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
