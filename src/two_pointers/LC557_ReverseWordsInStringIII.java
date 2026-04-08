package two_pointers;

public class LC557_ReverseWordsInStringIII {

    /**
     * LeetCode 557: Reverse Words in a String III
     * Link: https://leetcode.com/problems/reverse-words-in-a-string-iii/
     * * Time Complexity: O(N) where N is the length of the string.
     * Space Complexity: O(N) to store the character array.
     */
    public String reverseWords(String s) {
        char[] word = s.toCharArray();
        int start = 0;

        for (int end = 0; end <= word.length; end++) {
            // Check for space or end of the array to identify a word boundary
            if (end == word.length || word[end] == ' ') {
                // Reverse the identified word using the Two Pointers helper
                reverse(word, start, end - 1);
                // Move start to the beginning of the next word
                start = end + 1;
            }
        }
        return new String(word);
    }

    // Helper method using Two Pointers to reverse characters in-place
    private void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    // Main method for local testing
    public static void main(String[] args) {
        LC557_ReverseWordsInStringIII solution = new LC557_ReverseWordsInStringIII();

        String test1 = "Let's take LeetCode contest";
        System.out.println("Test 1 Result: " + solution.reverseWords(test1));
        // Expected: "s'teL ekat edoCteeL tsetnoc"

        String test2 = "Mr Ding";
        System.out.println("Test 2 Result: " + solution.reverseWords(test2));
        // Expected: "rM gniD"
    }
}