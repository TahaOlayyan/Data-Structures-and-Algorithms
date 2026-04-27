package stacks;

import java.util.HashMap;
import java.util.Stack;

public class LC20_ValidParentheses {

    /**
     * LeetCode 20: Valid Parentheses
     * Link: https://leetcode.com/problems/valid-parentheses/
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public boolean isValid(String s) {
        Stack<Character> bracket = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        char[] brackets = s.toCharArray();
        for (char ch : brackets) {
            // If it's an opening bracket (not in map keys), push to stack
            if (!map.containsKey(ch)) {
                bracket.push(ch);
            } else {
                // If it's a closing bracket, check for validity
                if (bracket.isEmpty()) {
                    return false;
                } else {
                    char last = bracket.pop();
                    if (last != map.get(ch)) {
                        return false;
                    }
                }
            }
        }
        return bracket.isEmpty();
    }

    public static void main(String[] args) {
        LC20_ValidParentheses solution = new LC20_ValidParentheses();
        System.out.println("Test 1 ('()'): " + solution.isValid("()"));       // Expected: true
        System.out.println("Test 2 ('()[]{}'): " + solution.isValid("()[]{}")); // Expected: true
        System.out.println("Test 3 ('(]'): " + solution.isValid("(]"));         // Expected: false
    }
}