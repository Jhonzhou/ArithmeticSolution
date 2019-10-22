package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;
import com.worker.bee.solution.bean.ListNode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 25. K 个一组翻转链表
 * 题目描述：
 * <p>
 * &emsp;&emsp;给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 示例 :
 * <p>
 * 给定这个链表：1->2->3->4->5
 * <p>
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * <p>
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * <p>
 * 说明 :
 * <p>
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 在真实的面试中遇到过这道题？
 */
public class ReverseKGroupListNode {
    @Test
    public void test() {
        ListNode listNode = ListNode.createByArray(new int[]{1, 2, 3, 4});
        ArrayList<Object> objects = new ArrayList<>();
        objects.add(listNode);
        PrintUtils.println(Arrays.toString(ListNode.toList(reverseKGroup(listNode, 2)).toArray()));
    }

    private ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int index = 0;
        ListNode result = new ListNode(0);
        result.next = head;

        //选取K个元素
        ListNode[] listNodes = new ListNode[k];
        ListNode temp = head;
        while (index < k && temp != null) {
            listNodes[index] = temp;
            temp = temp.next;
            index++;
        }
        if (index != k) {
            //不够K个元素
            return result.next;
        } else {
            //反转ListNodes中数据
            ListNode tempPre = result;
            int preIndex = 0, endIndex = k - 1;

            while (preIndex < endIndex) {
                reverseTwoListNode(tempPre, listNodes[endIndex - 1]);
                tempPre = listNodes[endIndex];
                preIndex++;
                endIndex--;
            }
            listNodes[0].next = reverseKGroup(listNodes[0].next, k);
        }
        return result.next;
    }

    private void reverseTwoListNode(ListNode preStart, ListNode preEnd) {
        ListNode start = preStart.next;
        ListNode end = preEnd.next;
        ListNode temp = end.next;

        preStart.next = end;
        preEnd.next = start;
        end.next = start.next;
        start.next = temp;

    }
}
