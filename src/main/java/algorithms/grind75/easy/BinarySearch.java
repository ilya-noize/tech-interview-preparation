package algorithms.grind75.easy;

/**
 * 704. Binary Search
 * <p>
 * Given an array of integers nums which is sorted in ascending order, and an integer target, write
 * a function to search target in nums. If target exists, then return its index. Otherwise, return
 * -1. You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * <a href="https://leetcode.com/problems/binary-search/description/">binary-search</a>
 */
public class BinarySearch {

    /**
     * as we have a sorted array the better way to find element in it is to use binary search we
     * need to divide array on subarrays and check if the target is greater or smaller than the
     * middle value of subarray.
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (target == nums[middle]) {
                return middle;
            } else if (target > nums[middle]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }
}
