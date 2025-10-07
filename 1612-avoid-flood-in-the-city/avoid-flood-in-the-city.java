class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Map<Integer, Integer> lakeLastRainDay = new HashMap<>();
        TreeSet<Integer> dryDays = new TreeSet<>();
        Arrays.fill(ans, 1);

        for (int i = 0; i < n; i++) {
            if (rains[i] > 0) {
                ans[i] = -1;
                if (lakeLastRainDay.containsKey(rains[i])) {
                    Integer dryDay = dryDays.higher(lakeLastRainDay.get(rains[i]));
                    if (dryDay == null) return new int[0];
                    ans[dryDay] = rains[i];
                    dryDays.remove(dryDay);
                }
                lakeLastRainDay.put(rains[i], i);
            } else {
                dryDays.add(i);
            }
        }
        return ans;
    }
}
