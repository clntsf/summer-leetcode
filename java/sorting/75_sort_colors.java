class Solution {
    /*
     * We implement a counting sort here, taking counts of
     * red, white and blue items in sums and then placing
     * them in the right places from the start of the array
     */
    public void sortColors(int[] nums) {
        int[] sums = new int[3];
        for (int x : nums) {
            sums[x]++;
        }

        // after counting we write each index with the array
        // with the corresponding item in our count array,
        // starting at 0 and moving up to 2.
        int writeIdx = 0;
        for (int i=0; i<3; i++) {
            int sum = sums[i];
            while (sum > 0) {
                nums[writeIdx++] = i;
                sum--;
            }
        }
    }
}