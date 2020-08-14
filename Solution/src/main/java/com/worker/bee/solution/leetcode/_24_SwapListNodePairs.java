package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;
import com.worker.bee.solution.bean.ListNode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 24. 两两交换链表中的节点
 * 题目描述：
 * <p>
 * &emsp;&emsp;给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class _24_SwapListNodePairs {
    @Test
    public void test() {
        ListNode listNode = ListNode.createByArray(new int[]{1, 2, 3, 4});
        PrintUtils.println(Arrays.toString(ListNode.toList(swapPairs(listNode)).toArray()));
    }

    /**
     * 递归解法
     */
    private ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = head.next;
        head.next = swapPairs(result.next);
        result.next = head;
        return result;
    }

    /**
     * 常规解法
     */
    private ListNode swapPairsMy(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode resultHead = new ListNode(0);


        resultHead.next = head;
        ListNode tempNode;
        ListNode current = head;
        ListNode pre = resultHead;
        while (current != null) {
            if (current.next == null) {
                break;
            }
            tempNode = current.next.next;
            pre.next = current.next;
            pre.next.next = current;
            current.next = tempNode;

            pre = current;
            current = current.next;

        }

        return resultHead.next;
    }
}
