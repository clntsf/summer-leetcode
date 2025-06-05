// https://leetcode.com/problems/lexicographically-smallest-equivalent-string/description
// 1061. Lexicographically Smallest Equivalent String (Daily Problem 5/6/2025)
// Difficulty: Medium

class Solution {

    // union-find algorithm basis - finds the root of the
    // union by iterating until the node is not a child
    private int findRoot(int[] links, int x) {
        while (links[x] != x) x = links[x];
        return x;
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {

        // Initialize nodes as own children (roots)
        int[] links = new int[26];
        for (int i=0; i<26; i++) {
            links[i] = i;
        }

        int l = s1.length();
        int a, b, aRoot, bRoot;
        for (int i=0; i<l; i++) {
            a = s1.charAt(i) - 'a';
            b = s2.charAt(i) - 'a';
            aRoot = findRoot(links, a);
            bRoot = findRoot(links, b);

            if (aRoot < bRoot) {
                links[bRoot] = links[aRoot];
            } else {
                links[aRoot] = links[bRoot];
            }

            // System.out.println(a + " " + b);
            // for (int j=0; j<26; j++) System.out.print(links[j] + " ");
            // System.out.println();
        }

        // flatten tree for speed
        for (int i=0; i<26; i++) {
            links[i] = findRoot(links, i);
        }

        // construct output by mutating original string (StringBuilder also works)
        char[] out = baseStr.toCharArray();
        for (int i=0; i<out.length; i++) {
            out[i] = (char)('a' + links[out[i] - 'a']);
        }

        return new String(out);
        
    }
}