package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 19. 删除链表的倒数第N个节点
 * 题目描述：
 * <p>
 * &emsp;&emsp;给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * 给定的 n 保证是有效的。
 * 进阶：
 * 你能尝试使用一趟扫描实现吗？
 * Related Topics 链表 双指针
 */
public class _19_RemoveNthFromEnd {
    @Test
    public void test() {
        int[] numbers = new int[]{1, 2, 3, 4, 5};
        ListNode head = null;
        ListNode temp = null;
        for (int index = 0; index < numbers.length; index++) {
            if (temp == null) {
                temp = new ListNode(numbers[index]);
                head = temp;
            } else {
                temp.next = new ListNode(numbers[index]);
                temp = temp.next;
            }
        }
        head = removeNthFromEnd(head, 2);
        List<Integer> resultList = new ArrayList<>();
        while (head != null) {
            resultList.add(head.val);
            head = head.next;
        }
        PrintUtils.println(Arrays.toString(resultList.toArray()));
    }

    private ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        int length = 1;
        while (head.next != null) {
            length++;
            head = head.next;
        }
        length = length - n;

        head = temp;
        while (length > 0) {
            head = head.next;
            length--;
        }
        head.next = head.next.next;
        return temp.next;
    }
    //错误，可以创建一个临时头结点，因为如果不创建的话，当仅有一个节点则无法移除该节点。
//    private ListNode removeNthFromEnd(ListNode head, int n) {
//        //1,2,3,4,5,
//        //倒数2
//        //1,2,3,5
//        int length = 1;
//        ListNode tempNode = head;
//        ListNode original = head;
//        while (head != null) {
//            if (length == n) {
//                break;
//            }
//            length++;
//            head = head.next;
//        }
//        if (head == null) {
//            return null;
//        }
//        ListNode pre = head;
//        while (head.next != null) {
//            head = head.next;
//            pre = tempNode;
//            tempNode = tempNode.next;
//        }
//        if (pre.next!=null) {
//            pre.next = pre.next.next;
//        }
//        return original;
//    }

    /**
     * 思路：
     * 1、找到和首节点相距n个节点的位置 first
     * 2、将first和首节点同时向后移动，当first移动到末尾是，则另一个则是改链表的倒数第N个节点
     * 3、创建临时首节点非常有用，否则只有一个节点需要单独做出许多判断
     */
    public ListNode removeNthFromEndFromServer(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }

}
