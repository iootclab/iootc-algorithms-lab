package com.iootc.lab.algocasts;

import com.iootc.lab.domain.TreeNode;

import java.util.Stack;

/**
 * P8.判断二叉树是否相同
 * <p>题目：给你两个二叉树，你要判断它们是否相同。这里所谓相同，指的是两棵树结构相同，并且相应节点上的数值相等。<br/>
 * <p>描述：比如说，给你的两棵二叉树都是：
 *
 *    1          1
 *   / \        / \
 *  2   4      2   4
 *
 * 它们的结构相同，相应节点上的值也相等，因此返回 true。 如果另一棵树是：
 *
 *    1
 *   / \
 *  2   5
 *
 * 或
 *
 *     1
 *    /
 *   2
 *  /
 * 4
 *
 * 两棵树则不相同，返回 false。
 *
 * @author Johnathon Yuan
 * @since 2021-05-17 20:35
 */
public class Question8 {

    // Time: O(n), Space: O(n)
    public boolean isSameTreeWithRecursive(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) {
            return true;
        }
        if (n1 == null || n2 == null) {
            return false;
        }

        return n1.value == n2.value
                && isSameTreeWithRecursive(n1.left, n2.left)
                && isSameTreeWithRecursive(n1.right, n2.right);
    }

    // Time: O(n), Space: O(n)
    public boolean isSameTreeIterative(TreeNode n1, TreeNode n2) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(n1);
        stack.push(n2);

        while (!stack.empty()) {
            TreeNode tn1 = stack.pop();
            TreeNode tn2 = stack.pop();
            if (tn1 == null && tn2 == null) {
                continue;
            }
            if (tn1 == null || tn2 == null) {
                return false;
            }
            if (tn1.value != tn2.value) {
                return false;
            }
            stack.push(tn1.left);
            stack.push(tn2.left);
            stack.push(tn1.right);
            stack.push(tn2.right);
        }
        return true;
    }
}
