/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.*;

class Solution {

    private int postorderIndex;
    private Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        postorderIndex = postorder.length - 1;


        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return build(postorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] postorder, int left, int right) {


        if (left > right) {
            return null;
        }


        int rootValue = postorder[postorderIndex--];

        TreeNode root = new TreeNode(rootValue);

        int rootIndex = inorderMap.get(rootValue);

        root.right = build(postorder, rootIndex + 1, right);

    
        root.left = build(postorder, left, rootIndex - 1);

        return root;
    }
}