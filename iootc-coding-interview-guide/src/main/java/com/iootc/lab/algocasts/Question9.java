package com.iootc.lab.algocasts;

import com.iootc.lab.domain.ListNode;

/**
 * P9.判断二叉树是否相同
 * <p>题目：给你两个二叉树，你要判断它们是否相同。这里所谓相同，指的是两棵树结构相同，并且相应节点上的数值相等。<br/>
 * <p>描述：比如说给你的单链表是：
 *
 * 1 -> 2 -> 3 -> 4 -> 5 -> null
 *
 * 你要返回的反转后的链表是：
 *
 * 5 -> 4 -> 3 -> 2 -> 1 -> null
 *
 * @author Johnathon Yuan
 * @since 2021-05-17 20:58
 */
public class Question9 {

    // Time: O(n), Space: O(1)
    public ListNode reverseListNode(ListNode head) {
        ListNode cur = head, pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}
