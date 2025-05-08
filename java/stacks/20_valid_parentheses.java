// https://leetcode.com/problems/valid-parentheses/description/
// 20. Valid Parentheses
// Difficulty: Easy

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {

        // initialize stack and split string into array
        Stack<Character> stack = new Stack<>();
        char[] schars = s.toCharArray();

        for (char c : schars) {

            // open bracket, add to stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }

            else {                      // closing bracket
                if (stack.isEmpty()) {  // no character on stack, bail out
                    return false;
                }

                // check for corresponding open bracket
                char last = stack.pop();
                if (c == ')' && last != '(') return false;
                if (c == '}' && last != '{') return false;
                if (c == ']' && last != '[') return false;
            }
        }

        // our string is only valid if there are no characters left on the stack
        return stack.isEmpty();
    }
}