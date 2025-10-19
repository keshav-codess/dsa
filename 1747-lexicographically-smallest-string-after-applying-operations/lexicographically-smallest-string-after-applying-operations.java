class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Set<String> seen = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        String ans = s;

        q.add(s);
        seen.add(s);

        while (!q.isEmpty()) {
            String curr = q.poll();
            if (curr.compareTo(ans) < 0)
                ans = curr;

            char[] chars = curr.toCharArray();
            for (int i = 1; i < chars.length; i += 2) {
                chars[i] = (char) (((chars[i] - '0' + a) % 10) + '0');
            }
            String added = new String(chars);

            String rotated = curr.substring(curr.length() - b) + curr.substring(0, curr.length() - b);

            if (seen.add(added))
                q.add(added);
            if (seen.add(rotated))
                q.add(rotated);
        }

        return ans;
    }
}