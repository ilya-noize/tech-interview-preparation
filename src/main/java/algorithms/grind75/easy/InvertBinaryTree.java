package algorithms.grind75.easy;

import algorithms.grind75.domain.TreeNode;

/**
 * 226. Invert Binary Tree
 * <p>
 * Given the root of a binary tree, invert the tree, and return its root.
 * <p>
 * <a href="https://leetcode.com/problems/invert-binary-tree/">invert-binary-tree</a>
 */
public class InvertBinaryTree {

    /**
     * To invert a binary tree we should change every left node with right node. If node is null, we
     * should stop the recursion. That means we reached the end of the tree. In our main function we
     * should define temp node to swap right node to left. It is also should be called recursively
     * on each left and right node of the tree. After all recursive calls we should return root
     * node
     * <p>
     * Time Complexity: O(n)
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
