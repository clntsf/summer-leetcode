class Solution {
    int currK = 0;

    /*
     * Function intuition: go through an inorder traversal,
     * incrementing currK each time we process a node and
     * returning the kth node processed.
     * 
     * The code below is a standard inorder traversal which
     * ignores null nodes (by returning an impossible value)
     */
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return -1;
        
        int left = kthSmallest(root.left, k);       // process left subtree
        if (left != -1) return left;

        if ((++currK) == k) return root.val;        // process node

        return kthSmallest(root.right, k);          // process right subtree
    }
}