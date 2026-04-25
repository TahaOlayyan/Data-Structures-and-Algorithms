package two_pointers;

public class LC557_ReverseWordsInStringIII {

    /**
     * LeetCode 557: Reverse Words in a String III
     * Link: https://leetcode.com/problems/reverse-words-in-a-string-iii/
     */

    // --- Approach 1: Two Pointers (The Optimal & Professional Way) ---
    // Time Complexity: O(N)
    // Space Complexity: O(N) - In Java, Strings are immutable, so we must use char[].
    public String reverseWords(String s) {
        char[] word = s.toCharArray();
        int start = 0;

        for (int end = 0; end <= word.length; end++) {
            if (end == word.length || word[end] == ' ') {
                reverse(word, start, end - 1);
                start = end + 1;
            }
        }
        return new String(word);
    }

    private void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    // --- Approach 2: Split & StringBuilder (The Clean Code Way) ---
    // Fast to write, but creates many objects in memory.
    public String reverseWordsApproach2(String s) {
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            result.append(new StringBuilder(word).reverse());
            result.append(" ");
        }
        return result.toString().trim();
    }

    // Main method for testing both approaches
    public static void main(String[] args) {
        LC557_ReverseWordsInStringIII solution = new LC557_ReverseWordsInStringIII();
        String input = "Let's take LeetCode contest";

        System.out.println("Approach 1 (Two Pointers): " + solution.reverseWords(input));
        System.out.println("Approach 2 (Clean Code):   " + solution.reverseWordsApproach2(input));
    }
}