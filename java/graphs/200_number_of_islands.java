// https://leetcode.com/problems/number-of-islands/description
// 200. Number of Islands
// Difficulty: Medium

class Solution {

    private char marker = 'a'; 
    private int numberOfIslands = 0;

    public void floodFill(char[][] grid, int x, int y)
    {
        // out of bounds
        if (x < 0 || y < 0 || x >= grid[0].length || y >= grid.length) {
            return;
        }
        if (grid[y][x] != '1') return;
        grid[y][x] = marker;
        floodFill(grid, x-1, y);
        floodFill(grid, x+1, y);
        floodFill(grid, x, y-1);
        floodFill(grid, x, y+1);
    }

    public int numIslands(char[][] grid)
    {
        int m = grid.length;
        int n = grid[0].length;
        for (int y=0; y<m; y++) {
            for (int x=0; x<n; x++) {
                if (grid[y][x] == '1') {
                    floodFill(grid, x, y);
                    marker++;
                    numberOfIslands++;
                }
            }
        }
        return numberOfIslands;
    }
}