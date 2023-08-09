package algorithms.grind75.easy;

import algorithms.grind75.domain.TreeNode;

/**
 * 110. Balanced Binary Tree
 * <p>
 * Given a binary tree, determine if it is height-balanced.
 * <p>
 * <a href="https://leetcode.com/problems/balanced-binary-tree/">balanced-binary-tree</a>
 */
public class BalancedBinaryTree {

    /**
     * We should calculate tree height and check if the heights of its two subtrees at any given
     * node do not differ by more than one. The best way to calculate height recursively traverse
     * the tree For that we should assign function that return the height of the subtree in the end
     * After we calculate the height of both subtrees we could compare both values and check if the
     * difference of heights of left and right subtree is more than one
     * Recursively repeat until we reach the end of the tree
     * <p>
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true; // An empty tree is considered balanced
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        // Check if the height difference is within the allowed limit
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }

        // Recursively check for balance in the subtrees
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        // when you calculate the height of a node's subtree,
        // you need to add 1 to the maximum of the heights of its left
        // and right subtrees to account for the current node's height
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
