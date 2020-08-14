package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 两数相加
 * 题目描述 ：
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class _2_TwoNumberSum {
    @Test
    public void test() {
//        ListNode l1 = toListNode(new int[]{9});
//        ListNode l2 = toListNode(new int[]{1, 9, 9, 9, 9, 9, 9, 9, 9, 9});
        ListNode l1 = toListNode(new int[]{2,4,3});
        ListNode l2 = toListNode(new int[]{5,6,4});

        ListNode listNode = addTwoNumbers(l1, l2);
        PrintUtils.println(Arrays.asList(listNodeToArray(listNode)));
        twoSum(new int[]{3,2,4},6);
    }
    public int[] twoSum (int[] numbers, int target) {
        // write code here
        int[] result=null;
        if(numbers.length<=0){
            return result;
        }
        ArrayList temp=new ArrayList(numbers.length);
        for(int index=0;index<numbers.length;index++){
            int x=target-numbers[index];
            if(temp.contains(numbers[index])){
                result=new int[2];
                result[0]=temp.indexOf(numbers[index]+1);
                result[1]=index+1;
            }else{
                temp.add(x);
            }
        }
        return result;
    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode current = null;
        int carry = 0;//标记是否有进位
        int x, y;//当前位置两个链表的值
        int sum;//当前链表数值相加之和
        while (l1 != null || l2 != null) {

            x = l1 == null ? 0 : l1.val;
            y = l2 == null ? 0 : l2.val;
            sum = x + y + carry;
            carry = sum / 10;
            if (current == null) {
                result = current = new ListNode(sum % 10);
            } else {
                current.next = new ListNode(sum % 10);
                current = current.next;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry != 0) {
            current.next = new ListNode(carry);
        }
        return result;
    }

    /**
     * 这是一个错误示例：
     * 1、未考虑使用整形转义相加，未考虑超出整形和double范围情况如int[]{1,9,9,9,9,9,9,9,9,9}即会失败
     * 2、空间复杂度和时间复杂度都未优化
     */
    @Deprecated
    public ListNode errorAddTwoNumbers(ListNode l1, ListNode l2) {
        double first = 0;
        double second = 0;
        int index1 = 0;
        int index2 = 0;
        while (index1 != -1 || index2 != -1) {
            first += l1.val * Math.pow(10, index1);
            if (l1.next != null) {
                l1 = l1.next;
                index1++;
            } else {
                index1 = -1;
            }
            second += l2.val * Math.pow(10, index2);
            if (l2.next != null) {
                l2 = l2.next;
                index2++;
            } else {
                index2 = -1;
            }
        }
        double sum = first + second;
        if (sum <= 0) {
            return new ListNode(0);
        }
        ListNode result = null;
        ListNode listNode = null;
        ListNode tempResult;
        while (sum > 0) {
            tempResult = new ListNode((int) (sum % 10));
            if (result == null) {
                listNode = result = tempResult;
            } else {
                result.next = tempResult;
                result = tempResult;
            }
            sum = sum / 10;
        }
        return listNode;
    }


    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    private Integer[] listNodeToArray(ListNode listNode) {
        if (listNode == null) {
            return new Integer[]{};
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            while (listNode != null) {
                list.add(listNode.val);
                listNode = listNode.next;
            }
            return list.toArray(new Integer[]{});
        }

    }

    private ListNode toListNode(int[] source) {
        if (source.length <= 0) {
            return null;
        }
        ListNode result = null, temp = null;
        for (int number : source) {
            if (temp == null) {
                result = temp = new ListNode(number);
            } else {
                temp.next = new ListNode(number);
                temp = temp.next;
            }
        }
        return result;
    }


}
