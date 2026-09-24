class Solution {

    private TreeNode first = null;
    private TreeNode second = null;
    private TreeNode prev = null;

    public void recoverTree(TreeNode root) {
        inorder(root);

        // Swap the incorrect values
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }

        // Left
        inorder(node.left);

        // Check current node against previous node
        if (prev != null && prev.val > node.val) {

            // First violation
            if (first == null) {
                first = prev;
            }

            // Second node involved in violation
            second = node;
        }

        prev = node;

        // Right
        inorder(node.right);
    }
}
