package algorithms.grind75.easy;

/**
 * 278. First Bad Version
 * <p>
 * You are a product manager and currently leading a team to develop a new product. Unfortunately,
 * the latest version of your product fails the quality check. Since each version is developed based
 * on the previous version, all the versions after a bad version are also bad. Suppose you have n
 * versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the
 * following ones to be bad. You are given an API bool isBadVersion(version) which returns whether
 * version is bad. Implement a function to find the first bad version. You should minimize the
 * number of calls to the API.
 * <p>
 * <a href="https://leetcode.com/problems/first-bad-version/">first-bad-version</a>
 */
public class FirstBadVersion extends VersionControl {

    private final int badVersion;

    public FirstBadVersion(int badVersion) {
        this.badVersion = badVersion;
    }

    /**
     * Since we want to minimize the number of API calls, using a binary search is an efficient way
     * to achieve that.
     * We start with a left pointer at the first version (1) and a right pointer at
     * the last version (n).
     * In each iteration of the while loop, we calculate the middle version
     * between the left and right pointers.
     * We then call the isBadVersion(mid) API to check if the current version is bad.
     * If isBadVersion(mid) returns true, it means the first bad version
     * is in the left half, so we update the right pointer to mid.
     * If isBadVersion(mid) returns false, it means the first bad version is in the right half,
     * so we update the left pointer to mid + 1.
     * We repeat this process until the left and right pointers converge, meaning we've
     * found the first bad version.
     * At the end of the loop, left will be pointing to the first bad
     * version.
     * <p>
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }


    @Override
    public boolean isBadVersion(int version) {
        return version >= badVersion;
    }
}

abstract class VersionControl {

    public abstract boolean isBadVersion(int version);
}
