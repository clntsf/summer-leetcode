// https://leetcode.com/problems/lexicographically-minimum-string-after-removing-stars/description
// 3170. Lexicographically Minimum String After Removing Stars (Daily Problem 7/6/2025)
// Difficulty: Medium

import java.util.Stack;

class Solution {
    public String clearStars(String s) {
        int starCount = 0;

        // create an array of stacks storing the occurrences of each character in reverse order
        Stack<Integer>[] locs = new Stack[26];
        for (int i=0; i<26; i++) {
            locs[i] = new Stack<>();
        }

        char[] chars = s.toCharArray();
        for (int i=0; i<chars.length; i++) {

            // when we see a star, we remove the occurrence of the smallest
            // character seen most recently to preserve lex. minimum
            // by modifying the array to put in a star
            if (chars[i] == '*') {
                starCount += 2;
                for (int c=0; c<26; c++) {
                    if (!locs[c].isEmpty()) {
                        int back = locs[c].pop();
                        chars[back] = '*';
                        break;
                    }
                }
            }
            else {
                locs[chars[i]-'a'].push(i);
            }
        }

        // to construct the output we put all non-star chars of chars into a string
        StringBuilder sb = new StringBuilder(chars.length-starCount);
        for (char c : chars) {
            if (c != '*') sb.append(c);
        }

        return sb.toString();
    }
}