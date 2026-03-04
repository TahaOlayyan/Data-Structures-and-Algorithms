package arrays_and_hashing;

import java.util.HashMap;

public class LC387_FirstUniqueCharacter {

    /**
     * LeetCode 387: First Unique Character in a String
     * Link: https://leetcode.com/problems/first-unique-character-in-a-string/
     * * Time Complexity: O(N) where N is the length of the string, since we traverse it twice.
     * Space Complexity: O(1) because the HashMap will store at most 26 lowercase English letters (or up to 256 for ASCII), which is a constant space limit.
     */
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        // Build the frequency map
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Find the first character with a frequency of 1
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }

    // Main method for local testing
    public static void main(String[] args) {
        LC387_FirstUniqueCharacter solution = new LC387_FirstUniqueCharacter();

        System.out.println("Test 1 ('leetcode'): " + solution.firstUniqChar("leetcode"));         // Expected: 0
        System.out.println("Test 2 ('loveleetcode'): " + solution.firstUniqChar("loveleetcode")); // Expected: 2
        System.out.println("Test 3 ('aabb'): " + solution.firstUniqChar("aabb"));                 // Expected: -1
    }
}