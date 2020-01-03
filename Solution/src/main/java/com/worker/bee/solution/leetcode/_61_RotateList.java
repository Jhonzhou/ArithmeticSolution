package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;
import com.worker.bee.solution.bean.ListNode;

import java.util.Arrays;

/**
 * 题目标题:
 * 61. Rotate List
 * 题目描述：
 * <p>
 * &emsp;&emsp;给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 * Related Topics 链表 双指针
 */
public class _61_RotateList {

    public static void main(String[] args) {
        Solution solution = new _61_RotateList().new Solution();
        ListNode head = ListNode.createByInt(5);
        PrintUtils.println(Arrays.toString(ListNode.toList(head).toArray()));
        ListNode result = solution.rotateRight(head, 2);
        PrintUtils.println(Arrays.toString(ListNode.toList(result).toArray()));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 1、先将链表组成闭环
         * 2、将尾指针向后移动size-k%size个位置，尾指针的下一个listNode为头指针
         * 考虑k可能大于size 所以移动位置为  size-k%size
         */
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null||head.next==null) {
                return head;
            }
            if (k <= 0) {
                return head;
            }
            ListNode temp = head;
            int size = 1;
            //head 和current互换
            while (temp.next != null) {
                temp = temp.next;
                size++;
            }
            temp.next = head;
            int currentIndex = 1;
            k = size - k%size;
            while (currentIndex <= k) {
//                PrintUtils.println(currentIndex + " head: " + head.val + " temp: " + temp.val+" k: "+k);
//                head = head.next;
                temp=temp.next;
                currentIndex++;

            }
            head = temp.next;
            temp.next = null;
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}