package algorithms.grind75.medium;

/**
 * 33. Search in Rotated Sorted Array
 * <p>
 * There is an integer array nums sorted in ascending order (with distinct values). Prior to being
 * passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k <
 * nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0],
 * nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot
 * index 3 and become [4,5,6,7,0,1,2]. Given the array nums after the possible rotation and an
 * integer target, return the index of target if it is in nums, or -1 if it is not in nums. You must
 * write an algorithm with O(log n) runtime complexity.
 * <p>
 * <a
 * href="https://leetcode.com/problems/search-in-rotated-sorted-array/">search-in-rotated-sorted-array</a>
 */
public class SearchInRotatedSortedArray {

    /**
     * We should use a little modified binary search to find target in possibly rotated sorted
     * array. First of all we should understand what part of the array is sorted. Let's define two
     * pointers to the start and last index of the array. After that in cycle while left pointer is
     * less or equal to right pointer we should try to find defined target. Divide array on two
     * parts by middle pointer If left part of the array is sorted than value by left pointer should
     * be less that value by middle one and if target value in between left and middle values else
     * we should check the right part of the array If the middle value is equals to target value
     * than we should return middle index else if we could not find target value in the whole array
     * than we should return -1;
     * <p>
     * Time Complexity: O(nlogn) Space Complexity: O(1)
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //check the left part of the array
            if (nums[left] <= nums[mid]) {
                //go left
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid - 1;
                } else { //go right
                    left = mid + 1;
                }
            } else { //check the right part of the array
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        //could not find target value in the given array
        return -1;
    }
}
