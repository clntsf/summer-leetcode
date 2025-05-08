// https://leetcode.com/problems/invert-binary-tree/description/
// 226. Invert Binary Tree
// Difficulty: Easy

class Solution {

    /**
     * Invert a binary tree, switching each right node with a left node
     * and vice versa. We don't need a helper function here, as the main
     * function includes all the information we need to pass down as
     * parameters
     *
     *   - At all steps in our traversal, 'root' represents the currently
     *     visited node, not necessarily the root of the whole tree
     *     (though this is the value upon the first call of the function)
     *
     *   - If the root (or any node in our traversal) is null, we ignore
     *     and return it, as it does not have any children to be processed
     *
     *   - If the root (current node) is not null, we keep a temp version
     *     of its left child (right works too), invert both children and
     *     swap them. Then we return the processed node to be used upwards
     *     in the tree.
     */
    public TreeNode invertTree(TreeNode root) {

        // root is null, ignore
        if (root == null) return null;

        // keep a temp version of the left node, invert both subtrees,
        // swap the nodes and return the altered root.
        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);

        return root;
    }
}