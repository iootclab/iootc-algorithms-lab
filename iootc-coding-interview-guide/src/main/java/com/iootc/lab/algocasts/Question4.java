package com.iootc.lab.algocasts;

import java.util.Stack;

/**
 * P4.判断二叉树是否对称
 * <p>题目：给你一个二叉树，你要判断它是否沿中轴线对称。<br/>
 * <p>描述：1. 比如说，给你的二叉树是：
 *            1
 *          /   \
 *         2     2
 *        / \   / \
 *       4   8 8   4
 *  这棵二叉树是沿中轴线对称的，因此要返回 true。如果我去掉最后这个 4：
 *            1
 *          /   \
 *         2     2
 *        / \   /
 *      4   8 8
 *
 *  就不对称了，这时就要返回 false。
 *
 *
 * @author Johnathon Yuan
 * @since 2021-05-13 23:40
 */
public class Question4 {

    public class TreeNode {

        private int value;

        private TreeNode left;

        private TreeNode right;

        public TreeNode(int x) {
            this.value = x;
        }
    }

    private boolean isSymmetric(TreeNode s, TreeNode t) {
        if (s != null && t != null) {
            return s.value == t.value && isSymmetric(s.left, t.right) && isSymmetric(s.right, t.left);
        } else {
            return s == null && t == null;
        }
    }

    // Time: O(n), Space: O(n)
    public boolean isSymmetricTreeRecursive(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    // Time: O(n), Space: O(n)
    public boolean isSymmetricTreeIterative(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);

        while (!stack.empty()) {
            TreeNode s = stack.pop(), t = stack.pop();
            if (s == null && t == null) {
                continue;
            }
            if (s == null || t == null) {
                return false;
            }
            if (s.value != t.value) {
                return false;
            }

            stack.push(s.left);
            stack.push(t.right);
            stack.push(s.right);
            stack.push(t.left);
        }

        return true;
    }
}
