package com.worker.bee.solution.leetcode;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.worker.bee.solution.PrintUtils;
import com.worker.bee.solution.bean.ListNode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 23. 合并K个排序链表
 * 题目描述：
 * <p>
 * &emsp;&emsp;合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class MergerKSortedListNode {
    @Test
    public void test() {
        ListNode listNode1 = ListNode.createByArray(new int[]{1, 4});
        ListNode listNode2 = ListNode.createByArray(new int[]{2, 3});
        ListNode listNode3 = ListNode.createByArray(new int[]{5, 8});
        ListNode listNode4 = ListNode.createByArray(new int[]{6, 9});
        ListNode listNode = mergeKLists(new ListNode[]{listNode1, listNode2, listNode3, listNode4});
        PrintUtils.println(Arrays.toString(ListNode.toList(listNode).toArray()));
    }

    private ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length <= 0) {
            return null;
        }
        int length = lists.length;
        if (length == 1) {
            return lists[0];
        }
        boolean hasLast = length % 2 != 0;
        int secondLength = (length + 1) / 2;
        ListNode[] local = new ListNode[secondLength];
        for (int index = 0; index < secondLength; index++) {
            int temp = 2 * index;
            if (hasLast && index == secondLength - 1) {
                local[index] = lists[length - 1];
            } else {
                local[index] = mergerTwoListNode(lists[temp], lists[temp + 1]);
            }
        }
        return mergeKLists(local);

    }

    private ListNode mergerTwoListNode(ListNode l1, ListNode l2) {
        ListNode tempHead = new ListNode(0);
        ListNode temp = tempHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        if (l1 != null) {
            temp.next = l1;
        }
        if (l2 != null) {
            temp.next = l2;
        }
        return tempHead.next;
    }

    private ListNode mergeKListsFist(ListNode[] lists) {
        if (lists == null || lists.length <= 0) {
            return null;
        }
        ListNode tempHead = new ListNode(0);
        int length = lists.length;
        int n = length / 2;
        boolean hasLast = length % 2 != 0;
        for (int index = 0; index < n; index++) {
            if (tempHead.next == null) {
                tempHead.next = mergerTwoListNode(lists[2 * index], lists[2 * index + 1]);
            } else {
                tempHead.next = mergerTwoListNode(tempHead.next, mergerTwoListNode(lists[2 * index], lists[2 * index + 1]));
            }
        }
        if (hasLast) {
            if (tempHead.next != null) {
                tempHead.next = mergerTwoListNode(tempHead.next, lists[length - 1]);
            } else {
                tempHead.next = lists[length - 1];
            }
        }
        return tempHead.next;
    }
}
