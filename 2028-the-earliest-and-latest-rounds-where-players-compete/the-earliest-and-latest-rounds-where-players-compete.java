class Solution {
    Map<String, int[]> memo = new HashMap<>();

    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        List<Integer> players = new ArrayList<>();
        for (int i = 1; i <= n; i++) players.add(i);
        return dfs(players, firstPlayer, secondPlayer, 1);
    }

    private int[] dfs(List<Integer> players, int fp, int sp, int round) {
        String key = players.toString();
        if (memo.containsKey(key)) return memo.get(key);

        int size = players.size();
        for (int i = 0; i < size / 2; i++) {
            int a = players.get(i);
            int b = players.get(size - 1 - i);
            if ((a == fp && b == sp) || (a == sp && b == fp)) {
                return new int[]{round, round};
            }
        }

        List<List<Integer>> nextRounds = new ArrayList<>();
        generateNextRound(players, 0, players.size() - 1, new ArrayList<>(), nextRounds, fp, sp);

        int minRound = Integer.MAX_VALUE;
        int maxRound = Integer.MIN_VALUE;

        for (List<Integer> next : nextRounds) {
           
            next.sort(Comparator.naturalOrder());
            int[] res = dfs(next, fp, sp, round + 1);
            minRound = Math.min(minRound, res[0]);
            maxRound = Math.max(maxRound, res[1]);
        }

        int[] result = new int[]{minRound, maxRound};
        memo.put(key, result);
        return result;
    }

    private void generateNextRound(List<Integer> players, int l, int r, List<Integer> temp,
                                   List<List<Integer>> results, int fp, int sp) {
        if (l > r) {
            results.add(new ArrayList<>(temp));
            return;
        }

        if (l == r) {
            temp.add(players.get(l));
            generateNextRound(players, l + 1, r, temp, results, fp, sp);
            temp.remove(temp.size() - 1);
            return;
        }

        int a = players.get(l), b = players.get(r);

        
        if ((a == fp && b == sp) || (a == sp && b == fp)) {
            return;
        }

        
        if (a == fp || b == fp) {
            temp.add(fp);
            generateNextRound(players, l + 1, r - 1, temp, results, fp, sp);
            temp.remove(temp.size() - 1);
        } 
        
        else if (a == sp || b == sp) {
            temp.add(sp);
            generateNextRound(players, l + 1, r - 1, temp, results, fp, sp);
            temp.remove(temp.size() - 1);
        } 
        
        else {
            temp.add(a);
            generateNextRound(players, l + 1, r - 1, temp, results, fp, sp);
            temp.remove(temp.size() - 1);

            temp.add(b);
            generateNextRound(players, l + 1, r - 1, temp, results, fp, sp);
            temp.remove(temp.size() - 1);
        }
    }
}
