// https://leetcode.com/problems/balanced-binary-tree/
// 110. Balanced Binary Tree
// Difficulty: Easy
 

class Solution {

    /*
     * Calculate the balance of a tree by evaluating the balance
     * of each node from the leaves upwards
     *   - When we reach a null node we return the depth
     *     of the node to the function call up the stack
     *
     *   - at a non-null node, we get the depths of the left
     *     and right subtrees. If either of these is -1 it 
     *     is an indication that a violation has occurred further
     *     down in the tree.
     *
     *   - If the heights are not -1 but differ by more than 1
     *     we return -1 to the function call up the stack to
     *     indicate that a violation has occurred.
     */
    private int balanceHelper(TreeNode root, int depth) {

        // empty node; depth of tree here == input depth
        if (root == null) return depth;

        int depthL = balanceHelper(root.left, depth+1);
        int depthR = balanceHelper(root.right, depth+1);

        // balance violated further down in tree, return -1
        if (depthL == -1 || depthR == -1) return -1;

        // balance violated at this node, return -1
        if (Math.abs(depthR-depthL) > 1) return -1;

        return Math.max(depthL, depthR);
    }

    public boolean isBalanced(TreeNode root) {
        return (balanceHelper(root, 0) != -1);
    }
}