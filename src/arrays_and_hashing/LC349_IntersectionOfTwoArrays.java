package arrays_and_hashing;

import java.util.HashSet;
import java.util.Arrays;

public class LC349_IntersectionOfTwoArrays {

    /**
     * LeetCode 349: Intersection of Two Arrays
     * Link: https://leetcode.com/problems/intersection-of-two-arrays/
     * * Time Complexity: O(N + M) where N and M are the lengths of the two arrays.
     * Space Complexity: O(N) to store the unique elements of the first array in a HashSet.
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();

        for (int num : nums1) {
            set1.add(num);
        }

        HashSet<Integer> resultSet = new HashSet<>();

        for (int i = 0; i < nums2.length; i++) {
            if (set1.contains(nums2[i])) {
                resultSet.add(nums2[i]);
            }
        }

        int[] finalResult = new int[resultSet.size()];
        int index = 0;   // Because there's no index in HashSet

        for (int num : resultSet) {
            finalResult[index++] = num;
        }

        return finalResult;
    }

    // Main method for local testing
    public static void main(String[] args) {
        LC349_IntersectionOfTwoArrays solution = new LC349_IntersectionOfTwoArrays();

        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println("Test 1: " + Arrays.toString(solution.intersection(nums1, nums2))); // Expected: [2]

        int[] nums3 = {4, 9, 5};
        int[] nums4 = {9, 4, 9, 8, 4};
        System.out.println("Test 2: " + Arrays.toString(solution.intersection(nums3, nums4))); // Expected: [9, 4] or [4, 9]
    }
}