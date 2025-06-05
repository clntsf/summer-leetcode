// https://leetcode.com/problems/candy/description
// 135. Candy (Daily Question 2/6/2025)
// Difficulty: Hard

class Solution {
    public int candy(int[] ratings) {
        int l = ratings.length;
        int[] out = new int[ratings.length];

        // first sweep: increasing subsequences from L-R
        out[0] = 1;
        for (int i = 1; i < l; i++) {
            if (ratings[i] > ratings[i-1]) out[i] = out[i-1]+1;
            else out[i] = 1;
        }

        // second sweep: increasing subsequences from R-L
        for (int i = l-2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1]) {
                out[i] = Math.max(out[i], out[i+1]+1);
            }
        }

        // Sum candies and return
        int total = 0;
        for (int x : out) {
            total += x;
        }

        return total;
    }
}