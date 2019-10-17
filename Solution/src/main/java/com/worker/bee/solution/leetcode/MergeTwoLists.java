package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;
import com.worker.bee.solution.bean.ListNode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 21. 合并两个有序链表
 * 题目描述：
 * <p>
 * &emsp;&emsp;将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class MergeTwoLists {
    @Test
    public void test() {
        ListNode l1 = ListNode.createByArray(new int[]{1, 3, 5, 7});
        ListNode l2 = ListNode.createByArray(new int[]{2, 4, 6, 8});
        ListNode listNode = mergeTwoLists(l1, l2);
        PrintUtils.println(Arrays.toString(ListNode.toList(listNode).toArray()));
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode temp = new ListNode(0);

        ListNode preHead = temp;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                preHead.next = l1;
                l1 = l1.next;
            } else {
                preHead.next = l2;
                l2 = l2.next;
            }
            preHead = preHead.next;
        }
        if (l1 != null) {
            preHead.next = l1;
        }
        if (l2 != null) {
            preHead.next = l2;
        }


        return temp.next;
    }
}
