// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description
// 236. Lowest Common Ancestor of a Binary Tree
// Difficulty: Medium

/*
 * Explanation: Here the problem somewhat evades quick intuition, but:
 * We can solve the problem by modifying a post-order traversal to find the
 * node for which p and q are in different subtrees. We do this by only returning
 * non-null values when p or q is in a node's subtree (inspect) and only returning
 * values other than p or q when they are in different subtrees (inspect also).
 * 
 * Note that since of course p or q could be the LCA, these can also be returned and
 * these will be handled properly by the one-in-subtree logic.
 */
class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) return root;    // base case

        // process subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) return root;     // p and q in different subtrees, root is LCA
        else if (left != null) return left;                 // p or q in left subtree, return non-null
        return right;                                       // p or q in right subtree, return non-null
    }
}