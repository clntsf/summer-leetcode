// https://leetcode.com/problems/count-operations-to-obtain-zero/description/
// 2169. Count Operations to Obtain Zero
// Difficulty: Easy

class Solution {
    public int countOperations(int num1, int num2) {
        int ops = 0;

        // instead of naively subtracting we can simulated repeated
        // subtraction by using modulo and division to reduce faster.
        while (num1 != 0 && num2 != 0) {
            if (num1 >= num2) {
                ops += (num1/num2);
                num1 %= num2;
            }
            else {
                ops += (num2/num1);
                num2 %= num1;
            }
        }
        return ops;
    }
}