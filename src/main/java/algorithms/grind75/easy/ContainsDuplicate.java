package algorithms.grind75.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 217. Contains Duplicate
 * <p>
 * Given an integer array nums, return true if any value appears at least twice in the array, and
 * return false if every element is distinct.
 * <p>
 * <a href=" https://leetcode.com/problems/contains-duplicate">contains-duplicate</a>/
 */
public class ContainsDuplicate {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public boolean containsDuplicateHashMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                return true;
            } else {
                map.put(num, 0);
            }
        }
        return false;
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public boolean containsDuplicateSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }
        return false;
    }

    /**
     * Time Complexity: O(n * log n)
     * Space Complexity: O(1)
     */
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                return true;
            }
        }
        return false;
    }
}
