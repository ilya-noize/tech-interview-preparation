package algorithms.grind75.medium;

import algorithms.grind75.domain.TreeNode;

/**
 * 98. Validate Binary Search Tree
 * <p>
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST). A valid BST
 * is defined as follows: The left subtree of a node contains only nodes with keys less than the
 * node's key. The right subtree of a node contains only nodes with keys greater than the node's
 * key. Both the left and right subtrees must also be binary search trees.
 * <p>
 * <a
 * href="https://leetcode.com/problems/validate-binary-search-tree/">validate-binary-search-tree</a>
 */
public class ValidateBinarySearchTree {

    /**
     * Time Complexity: O(n) Space complexity is determined by the space used for the recursion
     * stack during the traversal. In the worst case scenario, when the tree is completely
     * unbalanced (essentially a linked list), the recursion stack can go as deep as the number of
     * nodes in the tree, which results in O(n) space complexity. However, in the average case or in
     * balanced trees, the space complexity would be closer to O(log n), where log n is the height
     * of a balanced tree. So, while the worst-case space complexity is O(n), the average-case or
     * best-case space complexity is generally more efficient due to the nature of balanced binary
     * trees.
     */
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValid(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.val < min || node.val > max) {
            return false;
        }

        return isValid(node.left, min, node.val) && isValid(node.right, node.val, max);
    }
}
