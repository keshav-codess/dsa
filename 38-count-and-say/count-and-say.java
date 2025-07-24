class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";

        String prev = "1";

        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();

            int count = 1;
            for (int j = 1; j < prev.length(); j++) {
                if (prev.charAt(j) == prev.charAt(j - 1)) {
                    count++;
                } else {
                    sb.append(count).append(prev.charAt(j - 1));
                    count = 1;
                }
            }

            sb.append(count).append(prev.charAt(prev.length() - 1));

            prev = sb.toString();
        }

        return prev;
    }
}
