class Solution {

    private Map<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {

        // Handle an empty graph
        if (node == null) {
            return null;
        }

        // If already cloned, return the clone
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // Create a copy of the current node
        Node clone = new Node(node.val);

        // Store original node -> cloned node
        visited.put(node, clone);

        // Clone all neighbors
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }

        return clone;
    }
}
