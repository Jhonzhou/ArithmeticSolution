package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;
import com.worker.bee.solution.bean.ListNode;
import com.worker.bee.solution.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目标题:
 * 109. Convert Sorted List to Binary Search Tree
 */
public class _109_ConvertSortedListToBinarySearchTree {

    public static void main(String[] args) {
        Solution solution = new _109_ConvertSortedListToBinarySearchTree().new Solution();
        ListNode listNode = ListNode.createByArray(new int[]{-10, -3, 0, 5, 9});
        PrintUtils.print(listNode.val);
        test(listNode);
        PrintUtils.print(listNode.val);


    }

    private static void test(ListNode listNode) {
        listNode = listNode.next;
    }
//给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
//
// 示例:
//
// 给定的有序链表： [-10, -3, 0, 5, 9],
//
//一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
//
// Related Topics 深度优先搜索 链表


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public TreeNode sortedListToBST(ListNode head) {
            ArrayList<TreeNode> treeNodes = new ArrayList<>();
            return new TreeNode(0);
        }

        private void getSortedListToBST(ListNode head) {

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}