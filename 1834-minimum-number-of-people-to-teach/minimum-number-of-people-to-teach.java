import java.util.*;

class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int m = languages.length;
        List<Set<Integer>> lang = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            Set<Integer> set = new HashSet<>();
            for (int l : languages[i]) set.add(l);
            lang.add(set);
        }

        Set<Integer> needTeach = new HashSet<>();
        for (int[] f : friendships) {
            int u = f[0] - 1, v = f[1] - 1;
            boolean can = false;
            for (int l : lang.get(u)) {
                if (lang.get(v).contains(l)) {
                    can = true;
                    break;
                }
            }
            if (!can) {
                needTeach.add(u);
                needTeach.add(v);
            }
        }

        if (needTeach.isEmpty()) return 0;

        int ans = Integer.MAX_VALUE;
        for (int l = 1; l <= n; l++) {
            int count = 0;
            for (int u : needTeach) {
                if (!lang.get(u).contains(l)) count++;
            }
            ans = Math.min(ans, count);
        }
        return ans;
    }
}
