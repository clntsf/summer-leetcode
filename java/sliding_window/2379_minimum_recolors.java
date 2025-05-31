// https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks/description/
// 2379. Minimum Recolors to Get K Consecutive Black Blocks
// Difficulty: Easy

class Solution {
    public int minimumRecolors(String blocks, int k) {
        int minTotal = 0;
        int prevTotal = 0;

        // create the window by scoring the first k
        for (int i=0; i<k; i++) {
            if (blocks.charAt(i) == 'W') minTotal++;
        }

        /*
         * slide the window over, updating score and keeping
         * rolling minimum
         */
        prevTotal = minTotal;
        int l = blocks.length();
        for (int i=k; i<l; i++) {
            if (blocks.charAt(i) == 'W') prevTotal++;
            if (blocks.charAt(i-k) == 'W') prevTotal--;
            if (prevTotal < minTotal) minTotal = prevTotal;
        }

        return minTotal;
    }
}