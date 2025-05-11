// https://leetcode.com/problems/first-missing-positive/description/
// 41. First Missing Positive
// Difficulty: Hard

class Solution {
    /*
     * Intuition: somewhat related to the pigeonhole principle,
     * we can say that the first missing integer in an array of
     * size L is strictly <=L+1. This is as the highest possible
     * such integer would occur if the numbers 1..L were in the
     * array.
     * 
     * Hence, we can ignore all integers >L+1 (as these are not
     * candidates), as well as all x<=0 (these aren't either) and
     * use an algorithm to place each integer in the place in the
     * array it would be in if the format was as above (where
     * nums[x] == x+1 for all x in 1..L) and then doing a second
     * pass to find the first missing entry in this array.
     */
    public int firstMissingPositive(int[] nums) {
        int l = nums.length;

        // swapping pass; loop through the items of the array and
        // put them in the correct places
        for (int i=0; i<l; i++) {
            int x = nums[i];

            // prevents unneccessary swapping and allows swapped
            // items to be reswapped if they are not in the correct
            // place (to avoid missing swaps)
            while (x>0 && x<l && x != i+1 && nums[x-1] != x) {
                int tmp = nums[x-1];
                nums[x-1] = x;
                nums[i] = tmp;
                x = tmp;
            }
        }

        // verification pass: find smallest missing
        for (int j=0; j<l; j++) {
            if (nums[j] != j+1) return j+1;
        }

        // no missing in list, return L+1 (see above)
        return l+1;
    }
}