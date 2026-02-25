package arrays_and_hashing;

public class LC169_MajorityElement {

    /**
     * LeetCode 169: Majority Element
     * Link: https://leetcode.com/problems/majority-element/
     * * Time Complexity: O(N) where N is the size of the array, as we iterate through the array exactly once.
     * Space Complexity: O(1) because we only use two integer variables (candidate and power), requiring no extra memory.
     * * Algorithm used: Boyer-Moore Voting Algorithm.
     */
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int power = 0;     // Candidate Power

        for (int num : nums) {
            if (power == 0) {
                candidate = num;
            }
            if (num == candidate) {
                power++;
            } else {
                power--;
            }
        }
        return candidate;
    }

    // Main method for local testing
    public static void main(String[] args) {
        LC169_MajorityElement solution = new LC169_MajorityElement();

        int[] test1 = {3, 2, 3};
        int[] test2 = {2, 2, 1, 1, 1, 2, 2};

        System.out.println("Majority Element in test1: " + solution.majorityElement(test1)); // Expected: 3
        System.out.println("Majority Element in test2: " + solution.majorityElement(test2)); // Expected: 2
    }
}