class Solution {

    // Trie Node to represent each bit (0 or 1)
    static class TrieNode {
        TrieNode[] children = new TrieNode[2];
    }

    TrieNode root = new TrieNode();

    private void insert(int num) {
        TrieNode node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.children[bit] == null) {
                node.children[bit] = new TrieNode();
            }
            node = node.children[bit];
        }
    }

    // find max XOR of current number with elements 
    private int findMaxXOR(int num) {
        TrieNode node = root;
        int maxXOR = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            int opposite = 1 - bit;
            if (node.children[opposite] != null) {
                maxXOR |= (1 << i);
                node = node.children[opposite];
            } else {
                node = node.children[bit];
            }
        }
        return maxXOR;
    }

    public int findMaximumXOR(int[] nums) {
        int max = 0;

        for (int num : nums) {
            insert(num);
        }
        for (int num : nums) {
            max = Math.max(max, findMaxXOR(num));
        }

        return max;
    }
}
