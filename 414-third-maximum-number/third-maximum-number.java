import java.util.*;

class Solution {
    public int thirdMax(int[] nums) {
        TreeSet<Integer> top3 = new TreeSet<>();

        for (int num : nums) {
            top3.add(num);  

            if (top3.size() > 3) {
                top3.pollFirst(); 
            }
        }

        return top3.size() == 3 ? top3.first() : top3.last();
    }
}
