package arrays_and_hashing;

import java.util.*;

public class LC049_GroupAnagrams {

    /**
     * LeetCode 49: Group Anagrams
     * Link: https://leetcode.com/problems/group-anagrams/
     * * Time Complexity: O(N * K log K) where N is the number of strings, and K is the maximum length of a string.
     * Space Complexity: O(N * K) to store the hash map containing all strings.
     */

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] chArr = s.toCharArray();
            Arrays.sort(chArr);
            String key = new String(chArr);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }

    // Main method for local testing
    public static void main(String[] args) {
        LC049_GroupAnagrams solution = new LC049_GroupAnagrams();
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println("Output: " + solution.groupAnagrams(input));
    }
}