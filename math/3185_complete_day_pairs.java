/*
 * Our solution relies on the mathematical rule that
 * (a+b)%n is equal to a%n + b%n. As such, there are
 * only 24 residue classes to split the numbers into
 * greatly simplifying our problem
 */
class Solution {
    public long countCompleteDayPairs(int[] hours) {

        // constructing residue classes
        long[] modulos = new long[24];
        for (int x : hours) {
            modulos[x%24]++;
        }

        // classes 0 and 12 require slight care as they map to
        // themselves, so we adjust the formula to remove pairs
        // with the same element twice
        long x0 = modulos[0];
        long x12 = modulos[12];
        long sum = (x0 * (x0-1))/2 + (x12 * (x12-1))/2;

        // normal sum-of-products for the other classes
        for (int i=1; i<12; i++) {
            sum += modulos[i] * modulos[24-i];
        }
        return sum;
    }
}