
class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;
                map.computeIfAbsent(key, k -> new ArrayList<>()).add(grid[i][j]);
            }
        }
        
        for (Map.Entry<Integer, List<Integer>> e : map.entrySet()) {
            List<Integer> diag = e.getValue();
            if (e.getKey() >= 0) {
                diag.sort(Collections.reverseOrder());
            } else {
                Collections.sort(diag);
            }
        }
        
        Map<Integer, Integer> idx = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;
                List<Integer> diag = map.get(key);
                int k = idx.getOrDefault(key, 0);
                grid[i][j] = diag.get(k);
                idx.put(key, k + 1);
            }
        }
        
        return grid;
    }
}
