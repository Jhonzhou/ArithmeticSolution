package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;
import com.worker.bee.solution.bean.ListNode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 题目标题:
 * 82. Remove Duplicates from Sorted List II
 * 题目描述：
 * <p>
 * &emsp;&emsp;给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 * Related Topics 链表
 */
public class _82_RemoveDuplicatesFromSortedListIi {

    public static void main(String[] args) {
        Solution solution = new _82_RemoveDuplicatesFromSortedListIi().new Solution();
        int nums[] = new int[]{1, 1, 1, 2, 3, 3, 3, 4, 4, 5};
        ListNode listNode = ListNode.createByArray(nums);
        PrintUtils.println(Arrays.toString(
                ListNode.toList(
                        solution.deleteDuplicates(listNode)).toArray()
                )
        );
    }


//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode temp = new ListNode(-1);
            temp.next = head;
            ListNode pre = temp;
            ListNode current = head.next;
            while (current != null) {
                if (current.val == pre.next.val) {
                    while (current.val == pre.next.val) {
                        current = current.next;
                        if (current == null) {
                            pre.next = null;
                            return temp.next;
                        }
                    }
                    pre.next = current;
                } else {
                    pre = pre.next;
                }
                current = current.next;
            }

            return temp.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}