// https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words/description/
// 2131. Longest Palindrome by Concatenating Two Letter Words (Daily Problem 25 May 2025)
// Difficulty: Medium

class Solution {
    /*
     * Intuition: We can make a 26x26 array to store the counts of each possible word.
     * When we see a word, we check for the presence of its inverse in the table. If it
     * is present (i.e. word='ab' and 'ba' found, we remove one occurrence and add 4 to the)
     * length of the palindrome. If not, we add the seen word to the table.
     * 
     * At the end, we consider the edge case of a palindrome of odd word length, i.e. abccba.
     * for this, we go through the table's diagonal to check for any palindromic words (aa,bb,cc...)
     * left, and if so finally add 2 to the palindrome length.
     */
    public int longestPalindrome(String[] words) {
        int totalLength = 0;
        int[][] counts = new int[26][26];
        int a, b;

        // part 1: table population and inverse matching
        for (String wd : words) {
            a = wd.charAt(0) - 'a';
            b = wd.charAt(1) - 'a';
            if (counts[b][a] > 0) {
                totalLength += 4;
                counts[b][a]--;
            } else {
                counts[a][b]++;
            }
        }

        // part 2: odd-word-length palindrome check
        boolean seenPalindromicWord = false;
        for (int i = 0; i<26; i++) {
            if (counts[i][i] > 0) {
                seenPalindromicWord = true;
                break;
            }
        }
        
        return totalLength + (seenPalindromicWord ? 2 : 0);
    }
}