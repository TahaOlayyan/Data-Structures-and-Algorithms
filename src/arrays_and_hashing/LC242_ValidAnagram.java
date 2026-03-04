package arrays_and_hashing;

public class LC242_ValidAnagram {

    /**
     * LeetCode 242: Valid Anagram
     * Link: https://leetcode.com/problems/valid-anagram/
     * * Time Complexity: O(N) where N is the length of the strings. We iterate through the strings exactly once.
     * Space Complexity: O(1) because the frequency array size is strictly bounded to 26 elements, requiring constant extra space.
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] freq = new int[26];

        // Build the frequency array: increment for string 's', decrement for string 't'
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        // If any frequency is not zero, they are not anagrams
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0){
                return false;
            }
        }

        return true;
    }

    // Main method for local testing
    public static void main(String[] args) {
        LC242_ValidAnagram solution = new LC242_ValidAnagram();

        System.out.println("Test 1 ('anagram', 'nagaram'): " + solution.isAnagram("anagram", "nagaram")); // Expected: true
        System.out.println("Test 2 ('rat', 'car'): " + solution.isAnagram("rat", "car")); // Expected: false
    }
}