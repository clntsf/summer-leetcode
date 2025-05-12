// http s://leetcode.com/problems/rotate-image/
// 48. Rotate Image
// Difficulty: Medium

class Solution {

    /*
     * Intuition: To perform a 90-degree CW rotation
     * on a (square) matrix, we can:
     *  - reflect the matrix vertically
     * 
     *      1 2 3      7 8 9
     *      4 5 6  ->  4 5 6
     *      7 8 9      1 2 3
     * 
     *  - Transpose the matrix
     * 
     *      7 8 9      7 4 1
     *      4 5 6  ->  8 5 2
     *      1 2 3      9 6 3
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int d = n-1;
        int half = n/2;

        // vertical reflection
        for (int y=0; y<half; y++) {
            int[] tmp = matrix[y];
            matrix[y] = matrix[d-y];
            matrix[d-y] = tmp;
        }

        // transpose
        for (int y=0; y<n; y++) {
            for (int x=0; x<y; x++) {
                int tmp = matrix[x][y];
                matrix[x][y] = matrix[y][x];
                matrix[y][x] = tmp;
            }
        }

    }
}