package algorithms.grind75.easy;

import algorithms.grind75.domain.TreeNode;

/**
 * 104. Maximum Depth of Binary Tree
 * <p>
 * Given the root of a binary tree, return its maximum depth. A binary tree's maximum depth is the
 * number of nodes along the longest path from the root node down to the farthest leaf node.
 * <p>
 * <a
 * href="https://leetcode.com/problems/maximum-depth-of-binary-tree/">maximum-depth-of-binary-tree</a>
 */
public class MaximumDepthOfBinaryTree {

    /**
     * The depth of a binary tree is the length of the longest path from the root node to any leaf
     * node. Decided to use recursive way to calculate max depth of the tree.
     * If the root node is null, we return 0 because an empty tree has a depth of 0.
     * If the root node is not null, we calculate the depth of its left and
     * right subtrees using recursive calls to maxDepth.
     * <p>
     * Time Complexity: O(n) - where 'n' is the number of nodes in the binary tree.
     * Space Complexity: O(log n) on average for a balanced binary tree,
     * and O(n) in the worst case for a skewed binary tree.
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            // Base case: Empty tree has depth 0.
            return 0;
        } else {
            // Recursive case: Return the maximum of the depths of left and right subtrees,
            // and add 1 to account for the current level.
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }
}
