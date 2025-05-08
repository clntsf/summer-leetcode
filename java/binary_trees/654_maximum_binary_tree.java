// https://leetcode.com/problems/maximum-binary-tree/description/
// 654. Maximum Binary Tree
// Difficulty: Medium

class Solution {

    public TreeNode maxBTHelper(int[] nums, int lo, int hi) {
        // special cases for partitions with size 0 or 1
        if (lo == hi) return null;
        if (lo == hi-1) return new TreeNode(nums[lo]);

        // get the index of the largest value
        int maxIdx = lo;
        for (int i = lo; i < hi; i++) {
            if (nums[i] > nums[maxIdx]) { maxIdx = i; }
        }
        
        // create a node with that value
        TreeNode tn = new TreeNode(nums[maxIdx]);

        // assign its children as the left and right
        // partitions of the subarray around that node
        tn.left = maxBTHelper(nums, lo, maxIdx);
        tn.right = maxBTHelper(nums, maxIdx+1, hi);

        return tn;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        // return the result of the helper function on the whole array
        return maxBTHelper(nums, 0, nums.length);
    }
}