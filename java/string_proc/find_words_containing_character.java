// https://leetcode.com/problems/find-words-containing-character/
// 2942. Find Words Containing Character (Daily Problem 24 May 2025)
// Difficulty: Easy

import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> out = new ArrayList<>();
        String w;
        int l;
        for (int i=0; i<words.length; i++) {
            w = words[i];
            l = w.length();
            for (int j=0; j<l; j++) {
                if (w.charAt(j) == x) {
                    out.add(i);
                    break;
                }
            }
        }
        return out;
    }
}