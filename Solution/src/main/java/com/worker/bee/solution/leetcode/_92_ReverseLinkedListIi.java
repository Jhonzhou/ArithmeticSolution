package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;
import com.worker.bee.solution.bean.ListNode;

import java.util.List;

/**
 * 题目标题:
 * 92. Reverse Linked List II
 */
public class _92_ReverseLinkedListIi {

    public static void main(String[] args) {
        Solution solution = new _92_ReverseLinkedListIi().new Solution();
        ListNode listNode = ListNode.createByArray(new int[]{1, 2, 3, 4, 5});
        PrintUtils.printList(ListNode.toList(listNode));
        ListNode result = solution.reverseBetween(listNode, 2, 4);
        PrintUtils.printList(ListNode.toList(result));
    }
//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
//
// 说明:
//1 ≤ m ≤ n ≤ 链表长度。
//
// 示例:
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL
// Related Topics 链表


    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode reverseBetween(ListNode head, int m, int n) {
            ListNode resultHead = new ListNode(0);
            resultHead.next = head;
            ListNode mPreStart = resultHead;

            int currentIndex = 1;
            ListNode mTemp = resultHead.next;
            while (head != null) {
                ListNode current = head;
                head = head.next;
                if (currentIndex < m) {
                    mPreStart.next = current;
                    mPreStart = current;
                } else if (currentIndex == m) {
                    mPreStart.next = current;
                    mTemp = current;
                } else if (currentIndex > m && currentIndex <= n) {
                    ListNode temp = mPreStart.next;
                    mPreStart.next = current;
                    current.next = temp;
                    if (currentIndex == n) {
                        mTemp.next = head;
                        break;
                    }
                }
                currentIndex++;
            }

            return resultHead.next;
        }

        public ListNode reverseBetweenSelf1(ListNode head, int m, int n) {
            ListNode resultHead = new ListNode(0);
            resultHead.next = head;
            ListNode mPreStart = resultHead;

            int currentIndex = 1;
            ListNode mTemp = resultHead.next;
            while (head != null) {
                ListNode current = head;
                head = head.next;
                if (currentIndex < m) {
                    mPreStart.next = current;
                    mPreStart = current;
                } else if (currentIndex == m) {
                    mPreStart.next = current;
                    mTemp = current;
                } else if (currentIndex > m && currentIndex <= n) {
                    ListNode temp = mPreStart.next;
                    mPreStart.next = current;
                    current.next = temp;
                    if (currentIndex == n) {
                        mTemp.next = head;
                        break;
                    }
                }
                currentIndex++;
            }

            return resultHead.next;
        }
    }

}