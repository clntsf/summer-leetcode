// https://leetcode.com/problems/same-tree/description/
// 100. Same Tree
// Difficulty: Easy

class Solution {
    /*
     * Cases to consider (in order of implementation):
     *   - if both p and q are null the trees are the same
     *   - if one of p or q is null but not both the trees are not the same
     *   - if p and q are non-null but their values are inequal the trees are not the same
     *   - otherwise, p and q are the same if their left subtrees and right subtrees are the same
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {

        // check both null
        if (p == null && q == null) return true;                                // case 1

        // check one but not both null
        if (p == null ^ q == null) return false;                                // case 2

        // check node contents
        if (p.val != q.val) return false;                                       // case 3

        // evaluate subtrees
        return (isSameTree(p.left, q.left) && isSameTree(p.right, q.right));    // case 4
    }
}