package arrays_and_hashing;

import java.util.HashSet;

public class LC217_ContainsDuplicate {

    /**
     * LeetCode 217: Contains Duplicate
     * Link: https://leetcode.com/problems/contains-duplicate/
     * * Time Complexity: O(N) where N is the length of the array. We iterate through the array at most once.
     * Space Complexity: O(N) to store the elements in the HashSet in the worst case (all unique elements).
     */
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            // set.add() returns false if the element is already present in the set.
            // This is more efficient than checking set.contains() and then calling set.add().
            if (!set.add(num)) {
                return true;
            }
        }

        return false;
    }

    // Main method for local testing
    public static void main(String[] args) {
        LC217_ContainsDuplicate solution = new LC217_ContainsDuplicate();

        int[] test1 = {1, 2, 3, 1};
        System.out.println("Test 1: " + solution.containsDuplicate(test1)); // Expected: true

        int[] test2 = {1, 2, 3, 4};
        System.out.println("Test 2: " + solution.containsDuplicate(test2)); // Expected: false

        int[] test3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println("Test 3: " + solution.containsDuplicate(test3)); // Expected: true
    }
}