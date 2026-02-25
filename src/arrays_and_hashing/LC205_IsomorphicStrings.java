package arrays_and_hashing;

import java.util.HashMap;

public class LC205_IsomorphicStrings {

    /**
     * LeetCode 205: Isomorphic Strings
     * Link: https://leetcode.com/problems/isomorphic-strings/
     * * Time Complexity: O(N) where N is the length of the string.
     * Note: map.containsValue() takes O(K) where K is unique characters, but since K is bounded by the ASCII character set size (constant), the overall time complexity simplifies to O(N).
     * Space Complexity: O(1) or O(K) to store the hash map, which is bounded by the constant number of ASCII characters.
     */
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            if (map.containsKey(charS)) {
                if (map.get(charS) != charT) {
                    return false;
                }
            } else {
                if (map.containsValue(charT)) {
                    return false;
                }
                map.put(charS, charT);
            }
        }
        return true;
    }

    // Main method for local testing
    public static void main(String[] args) {
        LC205_IsomorphicStrings solution = new LC205_IsomorphicStrings();

        System.out.println("Test 1 ('egg', 'add'): " + solution.isIsomorphic("egg", "add"));     // Expected: true
        System.out.println("Test 2 ('foo', 'bar'): " + solution.isIsomorphic("foo", "bar"));     // Expected: false
        System.out.println("Test 3 ('paper', 'title'): " + solution.isIsomorphic("paper", "title")); // Expected: true
    }
}