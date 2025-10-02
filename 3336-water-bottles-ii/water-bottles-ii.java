class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int count = numBottles;
        int empty = numBottles;
        
        while (empty >= numExchange) {
            empty -= numExchange;   // spend numExchange empties
            count++;                // drink new full bottle
            empty++;                // add new empty
            numExchange++;          // increase exchange cost
        }
        
        return count;
    }
}
