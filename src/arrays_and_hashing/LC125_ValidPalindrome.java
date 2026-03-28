package two_pointers;

public class LC125_ValidPalindrome {

    /**
     * LeetCode 125: Valid Palindrome
     * Link: https://leetcode.com/problems/valid-palindrome/
     * * Time Complexity: O(N) where N is the length of the string, as we traverse it at most once.
     * Space Complexity: O(1) because we use two pointers on the original string without allocating extra space for a new string.
     */
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            char startChar = s.charAt(start);
            char endChar = s.charAt(end);

            // Skip non-alphanumeric characters from the left
            if (!Character.isLetterOrDigit(startChar)) {
                start++;
            }
            // Skip non-alphanumeric characters from the right
            else if (!Character.isLetterOrDigit(endChar)) {
                end--;
            }
            // Both are valid characters, compare them
            else {
                if (Character.toLowerCase(startChar) != Character.toLowerCase(endChar)) {
                    return false;
                }
                start++;
                end--;
            }
        }
        return true;
    }

    // Main method for local testing
    public static void main(String[] args) {
        LC125_ValidPalindrome solution = new LC125_ValidPalindrome();

        System.out.println("Test 1 ('A man, a plan, a canal: Panama'): " + solution.isPalindrome("A man, a plan, a canal: Panama")); // Expected: true
        System.out.println("Test 2 ('race a car'): " + solution.isPalindrome("race a car")); // Expected: false
        System.out.println("Test 3 (' '): " + solution.isPalindrome(" ")); // Expected: true
    }
}