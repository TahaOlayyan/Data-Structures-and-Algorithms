package arrays_and_hashing;

public class LC383_RansomNote {

    /**
     * LeetCode 383: Ransom Note
     * Link: https://leetcode.com/problems/ransom-note/
     * * Time Complexity: O(M + N) where M is the length of the magazine and N is the length of the ransom note.
     * Space Complexity: O(1) because we use a fixed-size frequency array of 26 integers.
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        // Early exit: if the note is longer than the magazine, it's impossible.
        if (magazine.length() < ransomNote.length()) {
            return false;
        }

        int[] freq = new int[26];

        // The Bank: Deposit character frequencies from the magazine
        for (int i = 0; i < magazine.length(); i++) {
            freq[magazine.charAt(i) - 'a']++;
        }

        // Withdraw: Check if we have enough characters for the ransom note
        for (int i = 0; i < ransomNote.length(); i++) {
            int charIndex = ransomNote.charAt(i) - 'a';
            freq[charIndex]--;

            if (freq[charIndex] < 0) {
                return false;
            }
        }

        return true;
    }

    // Main method for local testing
    public static void main(String[] args) {
        LC383_RansomNote solution = new LC383_RansomNote();

        System.out.println("Test 1 ('a', 'b'): " + solution.canConstruct("a", "b"));       // Expected: false
        System.out.println("Test 2 ('aa', 'ab'): " + solution.canConstruct("aa", "ab"));     // Expected: false
        System.out.println("Test 3 ('aa', 'aab'): " + solution.canConstruct("aa", "aab"));   // Expected: true
    }
}