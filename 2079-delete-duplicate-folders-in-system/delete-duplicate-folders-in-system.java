class Solution {
    class TrieNode {
        Map<String, TrieNode> children = new HashMap<>();
        boolean deleted = false;
    }

    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        TrieNode root = new TrieNode();

        // Step 1: Build Trie
        for (List<String> path : paths) {
            TrieNode node = root;
            for (String folder : path) {
                node = node.children.computeIfAbsent(folder, k -> new TrieNode());
            }
        }

        // Step 2: Map of serialized subtrees -> list of nodes
        Map<String, List<TrieNode>> subtreeToNodes = new HashMap<>();
        buildSubtreeToNodes(root, subtreeToNodes);

        // Step 3: Mark all duplicate subtrees for deletion
        for (List<TrieNode> nodes : subtreeToNodes.values()) {
            if (nodes.size() > 1) {
                for (TrieNode node : nodes) {
                    node.deleted = true;
                }
            }
        }

        // Step 4: DFS to collect remaining valid paths
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        constructPath(root, path, result);
        return result;
    }

    private String buildSubtreeToNodes(TrieNode node, Map<String, List<TrieNode>> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        List<String> keys = new ArrayList<>(node.children.keySet());
        Collections.sort(keys); // Ensure consistent serialization
        for (String key : keys) {
            TrieNode child = node.children.get(key);
            sb.append(key).append(buildSubtreeToNodes(child, map));
        }
        sb.append(")");

        String serial = sb.toString();
        if (!serial.equals("()")) {
            map.computeIfAbsent(serial, k -> new ArrayList<>()).add(node);
        }
        return serial;
    }

    private void constructPath(TrieNode node, List<String> path, List<List<String>> result) {
        for (Map.Entry<String, TrieNode> entry : node.children.entrySet()) {
            String folder = entry.getKey();
            TrieNode child = entry.getValue();
            if (!child.deleted) {
                path.add(folder);
                result.add(new ArrayList<>(path));
                constructPath(child, path, result);
                path.remove(path.size() - 1);
            }
        }
    }
}
