// https://leetcode.com/problems/minimum-path-sum/submissions/1631884372/
// 64. Minimum Path Sum
// Difficulty: Medium

class Solution {

    /*
     * Algorithm:
     * We will keep track of the shortest path to each square by:
     *   - First processing the top row and left column
     *   - Then going through each other square from top-left to
     *     bottom-right and updating its distance by the minimum
     *     of its top neighbor and left neighbor
     *   - Finally returning the distance to the bottom-right cell;
     */
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        // top row paths;
        int[] r = grid[0];
        for (int i=1; i<m; i++) {
            r[i] += r[i-1];
        }

        // left column paths
        for (int j=1; j<n; j++) {
            grid[j][0] += grid[j-1][0];
        }

        // process rest of array (load rows once for efficiency)
        for (int i=1; i<n; i++) {
            r = grid[i-1];
            for (int j=1; j<m; j++) {
                grid[i][j] += Math.min(r[j], grid[i][j-1]);
            }
        }

        return grid[n-1][m-1];
    }
}