class Solution {
    public int maximumGain(String s, int x, int y) {
        if (x > y) {
            Result r1 = removePattern(s, 'a', 'b', x);
            Result r2 = removePattern(r1.remaining, 'b', 'a', y);
            return r1.score + r2.score;
        }
         else {
            Result r1 = removePattern(s, 'b', 'a', y);
            Result r2 = removePattern(r1.remaining, 'a', 'b', x);
            return r1.score + r2.score;
        }
    }

    private Result removePattern(String s, char first, char second, int points) {
        StringBuilder sb = new StringBuilder();
        int score = 0;

        for (char ch : s.toCharArray()) {
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == first && ch == second) {
                sb.deleteCharAt(sb.length() - 1);
                score += points;
            } else {
                sb.append(ch);
            }
        }

        return new Result(sb.toString(), score);
    }

    private static class Result {
        String remaining;
        int score;

        Result(String remaining, int score) {
            this.remaining = remaining;
            this.score = score;
        }
    }
}
