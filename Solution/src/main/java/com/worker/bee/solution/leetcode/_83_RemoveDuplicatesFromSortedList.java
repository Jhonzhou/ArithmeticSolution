package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;
import com.worker.bee.solution.bean.ListNode;

import java.util.Arrays;

/**
 * 题目标题:
 * 83. Remove Duplicates from Sorted List
 * 题目描述：
 * <p>
 * &emsp;&emsp;给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->1->2
 * 输出: 1->2
 * <p>
 * 示例 2:
 * <p>
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 * Related Topics 链表
 */
public class _83_RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {
        Solution solution = new _83_RemoveDuplicatesFromSortedList().new Solution();
        int nums[] = new int[]{1, 1, 2, 3, 3};
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
            ListNode current = head.next;
            ListNode pre = head;
            while (current != null) {
                if (pre.val == current.val) {
                    pre.next = current.next;
                } else {
                    pre = pre.next;
                }

                current = current.next;
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}