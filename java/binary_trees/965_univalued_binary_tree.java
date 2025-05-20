// https://leetcode.com/problems/univalued-binary-tree/
// Univalued Binary Tree
// Difficulty: Easy

class Solution {

    /*
     * Check if a tree is Univalued - i.e. every node has the same value.
     * Given a value we know is in the root node, we check each
     * non-null child for this value and process their subtree recursively
     * as well. 
     */
    public boolean isUnivalRecursive(TreeNode root, int val) {
        // Ignore null nodes
        if (root == null) return true;

        // Check root equality
        if (root.val != val) return false;

        // Check child univalue
        return (
            isUnivalRecursive(root.left, val) &&
            isUnivalRecursive(root.right, val)
        );
    }

    /*
     * No additional logic is needed, we can just return
     * the result of the helper function called on the root
     * we use root.val as the initial val, as the value of
     * all nodes must be equal to that of the root.
     */
    public boolean isUnivalTree(TreeNode root) {
        // we don't have to handle the case of a null root as we are given 1<=|V|<=100
        return isUnivalRecursive(root, root.val);
    }
}