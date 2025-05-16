class Solution {

    /*
     * Intuition: We perform a preorder traversal of the tree.
     * At each node, if it is a leaf we return the root-to-leaf
     * number for this path, otherwise we process its left and right
     * children. Null nodes are ignored.
     */
    private int helper(TreeNode root, int sum) {
        if (root == null) return 0;
        int currsum = 10*sum + root.val;

        // at leaf, return number
        if (root.left == null && root.right == null) return currsum;

        // iterate down the tree
        return helper(root.left, currsum) + helper(root.right, currsum);
    }

    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }
}