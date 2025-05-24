// https://leetcode.com/problems/type-of-triangle/
// 3024. Types of Triangles (Daily Problem 19 May 2025)
// Difficulty: Easy

class Solution {
    public String triangleType(int[] nums) {

        // triangle theorem to check validity
        int maxside = Math.max(nums[0],Math.max(nums[1],nums[2]));
        if (nums[0] + nums[1] + nums[2] <= 2*maxside) {
            return "none";
        }

        if (nums[0] == nums[1]) {
            return ((nums[1] == nums[2]) ? "equilateral" : "isosceles");
        }
        if (nums[1] == nums[2] || nums[0] == nums[2]) return "isosceles";
        return "scalene";
    }
}