package two_pointers;

import java.util.Arrays;

public class LC283_MoveZeroes {

    /**
     * LeetCode 283: Move Zeroes
     * Link: https://leetcode.com/problems/move-zeroes/
     * * Time Complexity: O(N) where N is the number of elements in the array.
     * Space Complexity: O(1) as we modify the array in-place.
     */
    public void moveZeroes(int[] nums) {
        int start = 0;
        int end = 1;

        while (end < nums.length) {
            // Case 1: Current start is not zero, just move both pointers forward
            if (nums[start] != 0) {
                start++;
                end++;
            }
            // Case 2: Start is zero and end is non-zero, swap them
            else if (nums[end] != 0) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end++;
            }
            // Case 3: Both are zero, move end forward to find a non-zero element
            else {
                end++;
            }
        }
    }

    // Main method for local testing
    public static void main(String[] args) {
        LC283_MoveZeroes solution = new LC283_MoveZeroes();

        int[] test1 = {0, 1, 0, 3, 12};
        solution.moveZeroes(test1);
        System.out.println("Test 1: " + Arrays.toString(test1)); // Expected: [1, 3, 12, 0, 0]

        int[] test2 = {0};
        solution.moveZeroes(test2);
        System.out.println("Test 2: " + Arrays.toString(test2)); // Expected: [0]
    }
}