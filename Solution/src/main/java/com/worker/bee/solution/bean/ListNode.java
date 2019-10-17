package com.worker.bee.solution.bean;

import java.util.ArrayList;
import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static ListNode createByArray(int[] numbers) {
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
        return head;
    }
    public static List<Integer> toList(ListNode head){
        List<Integer> resultList = new ArrayList<>();
        while (head != null) {
            resultList.add(head.val);
            head = head.next;
        }
        return resultList;
    }
}
