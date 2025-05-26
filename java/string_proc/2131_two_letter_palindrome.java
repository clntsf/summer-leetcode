// https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words/description/
// 2131. Longest Palindrome by Concatenating Two Letter Words (Daily Problem 25 May 2025)
// Difficulty: Medium

class Solution {
    public int longestPalindrome(String[] words) {
        int totalLength = 0;
        int[][] counts = new int[26][26];
        int a, b;
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