class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        ArrayList<Integer> duplicates = new ArrayList<>();

        for (int num : nums) {
            if (seen.contains(num)) {
                duplicates.add(num);
            } else {
                seen.add(num);
            }
        }

        return new int[]{duplicates.get(0), duplicates.get(1)};
    }
}