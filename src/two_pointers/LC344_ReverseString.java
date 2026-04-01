package two_pointers;

public class LC344_ReverseString {

    /**
     * LeetCode 344: Reverse String
     * Link: https://leetcode.com/problems/reverse-string/
     * * Time Complexity: O(N) where N is the length of the character array.
     * Space Complexity: O(1) as we perform the reversal in-place using two pointers.
     */
    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;

        while (start < end) {
            // Standard swap logic using a temporary variable
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;

            start++;
            end--;
        }
    }

    // Main method for local testing
    public static void main(String[] args) {
        LC344_ReverseString solution = new LC344_ReverseString();

        char[] test1 = {'h', 'e', 'l', 'l', 'o'};
        solution.reverseString(test1);
        System.out.print("Test 1 Result: ");
        System.out.println(test1); // Expected: ["o","l","l","e","h"]

        char[] test2 = {'H', 'a', 'n', 'n', 'a', 'h'};
        solution.reverseString(test2);
        System.out.print("Test 2 Result: ");
        System.out.println(test2); // Expected: ["h","a","n","n","a","H"]
    }
}