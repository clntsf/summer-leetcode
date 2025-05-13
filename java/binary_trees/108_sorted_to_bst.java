// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
// 108. Convert Sorted Array to Binary Search Tree
// Difficulty: Easy

class Solution {

    /*
     * This is a modified binary search, where at each step we
     * turn the element at mid into a node and give it the result
     * of the helper on its left and right partitions as its children
     * 
     */
    private TreeNode helper(int[] nums, int lo, int hi) {
        if (hi <= lo) return null;

        // get mid (avoid overflow bugs with high length)
        int mid = lo + (hi-lo)/2;

        // Assign mid and add children
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, lo, mid);
        root.right = helper(nums, mid+1, hi);

        return root;
    }

    // call helper on nums with full array
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums,0,nums.length);
    }
}