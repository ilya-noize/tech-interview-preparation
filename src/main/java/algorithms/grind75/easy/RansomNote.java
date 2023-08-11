package algorithms.grind75.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 383. Ransom Note
 * <p>
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using
 * the letters from magazine and false otherwise. Each letter in magazine can only be used once in
 * ransomNote.
 * <p>
 * <a href="https://leetcode.com/problems/ransom-note">ransom-note</a>
 */
public class RansomNote {

    /**
     * Use a HashMap approach to count the occurrences of each character in the magazine string.
     * Then iterate through the characters of the ransomNote string and check if there are enough
     * available characters in the magazine to construct the ransom note. If there are enough
     * characters, decrement the count in the map.
     * <p>
     * Time Complexity: O(m+n) where m is the length of the magazine string and n is the length of
     * the ransomNote string.
     * Space Complexity: O(m) where m is the length of the magazine string.
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || magazine == null) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char letter : magazine.toCharArray()) {
            map.put(letter, map.getOrDefault(letter, 0) + 1);
        }

        for (char letter : ransomNote.toCharArray()) {
            if (!map.containsKey(letter) || map.get(letter) <= 0) {
                return false;
            }
            map.put(letter, map.get(letter) - 1);
        }

        return true;
    }
}
