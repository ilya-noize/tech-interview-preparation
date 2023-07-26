package algorithms.grind75.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum
 * <p>
 * Given an array of integers nums and an integer target, return indices of the two numbers such
 * that they add up to target. You may assume that each input would have exactly one solution, and
 * you may not use the same element twice. You can return the answer in any order.
 * <p>
 * <a href="https://leetcode.com/problems/two-sum/">...</a>
 */
public class TwoSum {

    /**
     * We need two loops one inside the other.
     * Outer loop will loop over the array and the inner loop iterate for each element visited.
     * Each time we should sum two values and when we get the target value we could get founded indexes
     * <p>
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public int[] twoSumBruteForce(int[] nums, int target) {
        int firstValue = 0;
        int secondValue = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    firstValue = i;
                    secondValue = j;
                }
            }
        }
        return new int[]{firstValue, secondValue};
    }

    /**
     * We could reduce time complexity if we use hash map in our algorithm.
     * This time we need to loop over each element of the array only once.
     * We can just check if the difference of the target value and the currently visited element of the array exists in the hashmap
     * <p>
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int keyToFind = target - nums[i];
            if (map.containsKey(keyToFind)) {
                result[0] = map.get(keyToFind);
                result[1] = i;
            }
            map.put(nums[i], i);
        }
        return result;
    }
}
