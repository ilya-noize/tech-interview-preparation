package algorithms.grind75.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 242. Valid Anagram
 * <p>
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise. An Anagram
 * is a word or phrase formed by rearranging the letters of a different word or phrase, typically
 * using all the original letters exactly once.
 * <p>
 * <a href="https://leetcode.com/problems/valid-anagram/description/">valid-anagram</a>
 */
public class ValidAnagram {

    /**
     * Time Complexity: O(n log(n)) average as we use Arrays.sort() that is Timsort under the hood
     * Space Complexity: O(n)
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sortedFirstString = s.toCharArray();
        Arrays.sort(sortedFirstString);
        char[] sortedSecondString = t.toCharArray();
        Arrays.sort(sortedSecondString);

        for (int i = 0; i < sortedFirstString.length; i++) {
            if (sortedFirstString[i] != sortedSecondString[i]) {
                return false;
            }
        }

        return true;
    }

    /**
     * HashMap approach Time Complexity: O(n) Space Complexity: O(n)
     */
    public boolean isAnagramHashTableApproach(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) - 1);
        }
        for (Integer value : map.values()) {
            if (value > 0) {
                return false;
            }
        }

        return true;
    }
}
