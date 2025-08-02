class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> freq = new HashMap<>();
        int n = basket1.length;
        
        for (int x : basket1) freq.put(x, freq.getOrDefault(x, 0) + 1);
        for (int x : basket2) freq.put(x, freq.getOrDefault(x, 0) - 1);
        
        List<Integer> extra1 = new ArrayList<>();
        List<Integer> extra2 = new ArrayList<>();
        int minFruit = Integer.MAX_VALUE;
        
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            int fruit = e.getKey();
            int count = e.getValue();
            minFruit = Math.min(minFruit, fruit);
            
            if (count % 2 != 0){
                return -1; 
            } 
            
            if (count > 0) { 
                for (int i = 0; i < count / 2; i++) extra1.add(fruit);
            } 
            
            else { 
                for (int i = 0; i < -count / 2; i++) extra2.add(fruit);
            }
        }
        
        Collections.sort(extra1);
        extra2.sort(Collections.reverseOrder());
        
        long cost = 0;
        for (int i = 0; i < extra1.size(); i++) {
            cost += Math.min(Math.min(extra1.get(i), extra2.get(i)), 2 * minFruit);
        }
        
        return cost;
    }
}