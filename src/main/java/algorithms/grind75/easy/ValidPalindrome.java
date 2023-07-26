package algorithms.grind75.easy;

/**
 * 125. Valid Palindrome
 * <p>
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and
 * removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric
 * characters include letters and numbers. Given a string s, return true if it is a palindrome, or
 * false otherwise.
 * <p>
 * <a href="https://leetcode.com/problems/valid-palindrome/">valid-palindrome</a>
 */
public class ValidPalindrome {

    /**
     * Use two pointers approach to reduce time complexity Assign pointer in the beginning and the
     * end of the string. While start pointer is less or equals to end pointer we check if the
     * character is letter or digit, if it's not increment/decrement the correct pointer when we got
     * two letters we should cast them to lower case and check if they are equal if not - the string
     * is not a palindrome
     * <p>
     * if we completely finished the loop - the string is palindrome
     * <p>
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public boolean isPalindrome(String s) {
        //empty string is also a palindrome
        if (s.isEmpty()) {
            return true;
        }
        int start = 0;
        int last = s.length() - 1;
        while (start <= last) {
            char currFirst = s.charAt(start);
            char currLast = s.charAt(last);
            if (!Character.isLetterOrDigit(currFirst)) {
                start++;
            } else if (!Character.isLetterOrDigit(currLast)) {
                last--;
            } else {
                if (Character.toLowerCase(currFirst) != Character.toLowerCase(currLast)) {
                    return false;
                }
                start++;
                last--;
            }
        }
        return true;
    }
}
