package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;
import com.worker.bee.solution.bean.ListNode;

import java.util.Arrays;

/**
 * 题目标题:
 * 86. Partition List
 * 题目描述：
 * <p>
 * &emsp;&emsp;给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * <p>
 * 你应当保留两个分区中每个节点的初始相对位置。
 * <p>
 * 示例:
 * <p>
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 * <p>
 * Related Topics 链表 双指针
 */
public class _86_PartitionList {

    public static void main(String[] args) {
        Solution solution = new _86_PartitionList().new Solution();
        int[] nums = {1, 4, 3, 2, 5, 2};
        ListNode listNode = ListNode.createByArray(nums);
        int x = 3;
        ListNode partition = solution.partition(listNode, x);
        PrintUtils.println(Arrays.toString(ListNode.toList(partition).toArray()));
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
        public ListNode partition(ListNode head, int x) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode result = new ListNode(-1);

            ListNode small = result;
            ListNode big = null;
            ListNode bigStart = null;

            ListNode current = head;
            while (current != null) {
                if (current.val < x) {
                    small.next = current;
                    small = current;
                } else {
                    if (bigStart == null) {
                        big = current;
                        bigStart = big;
                    } else {
                        big.next = current;
                        big = current;
                    }
                }
                current = current.next;
            }
            if (big != null) {
                big.next = null;
            }

            small.next = bigStart;
            return result.next;
        }

        public ListNode partitionServer(ListNode head, int x) {

            ListNode before_head = new ListNode(0);
            ListNode before = before_head;
            ListNode after_head = new ListNode(0);
            ListNode after = after_head;

            while (head != null) {

                if (head.val < x) {
                    before.next = head;
                    before = before.next;
                } else {
                    after.next = head;
                    after = after.next;
                }

                head = head.next;
            }

            after.next = null;

            before.next = after_head.next;

            return before_head.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}