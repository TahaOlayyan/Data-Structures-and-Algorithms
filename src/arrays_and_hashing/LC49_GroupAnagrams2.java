package arrays_and_hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LC49_GroupAnagrams2 {

    /**
     * LeetCode 49: Group Anagrams
     * Link: https://leetcode.com/problems/group-anagrams/
     * Time Complexity: O(N * K log K) where N is the number of strings, and K is the maximum length of a string.
     * Space Complexity: O(N * K) to store all strings in the HashMap.
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);

            // Optimization: Create the string object ONLY ONCE
            String sortedKey = new String(chars);

            // Pro Java Move: computeIfAbsent does the check and initialization in one step
            map.computeIfAbsent(sortedKey, k -> new ArrayList<>()).add(word);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        LC49_GroupAnagrams solution = new LC49_GroupAnagrams();
        String[] test1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println("Test 1: " + solution.groupAnagrams(test1));
        // Expected grouping: [["bat"], ["nat","tan"], ["ate","eat","tea"]] (order may vary)
    }
}