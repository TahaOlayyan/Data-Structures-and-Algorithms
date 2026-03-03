package arrays_and_hashing;

import java.util.HashMap;

public class LC290_WordPattern {

    /**
     * LeetCode 290: Word Pattern
     * Link: https://leetcode.com/problems/word-pattern/
     * * Time Complexity: O(N^2) in the worst case due to `map.containsValue()`, which takes O(N) time
     * inside the O(N) loop. Using an additional HashSet for 'used words' would optimize this to O(N).
     * Space Complexity: O(N) where N is the number of words, to store the split array and the HashMap.
     */
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");

        if (pattern.length() != words.length) {
            return false;
        }

        HashMap<Character, String> map = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);

            if (map.containsKey(c)) {
                if (!map.get(c).equals(words[i])) {
                    return false;
                }
            } else {
                if (map.containsValue(words[i])) {
                    return false;
                }
                map.put(c, words[i]);
            }
        }
        return true;
    }

    // Main method for local testing
    public static void main(String[] args) {
        LC290_WordPattern solution = new LC290_WordPattern();

        System.out.println("Test 1 ('abba', 'dog cat cat dog'): " + solution.wordPattern("abba", "dog cat cat dog")); // Expected: true
        System.out.println("Test 2 ('abba', 'dog cat cat fish'): " + solution.wordPattern("abba", "dog cat cat fish")); // Expected: false
        System.out.println("Test 3 ('aaaa', 'dog cat cat dog'): " + solution.wordPattern("aaaa", "dog cat cat dog")); // Expected: false
    }
}