package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;
import com.worker.bee.solution.bean.TreeNode;

/**
 * 题目标题:
 * 114. Flatten Binary Tree to Linked List
 */
public class _114_FlattenBinaryTreeToLinkedList {

    public static void main(String[] args) {
        Solution solution = new _114_FlattenBinaryTreeToLinkedList().new Solution();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2, new TreeNode(3), new TreeNode(4));
        treeNode.right = new TreeNode(5, null, new TreeNode(6));
        solution.flatten(treeNode);
        while (treeNode != null) {
            PrintUtils.println(treeNode.val);
            if (treeNode.left!=null) {
                PrintUtils.println(treeNode.left.val);
            }
            treeNode = treeNode.right;
        }
    }
//给定一个二叉树，原地将它展开为一个单链表。
//
//
//
// 例如，给定二叉树
//
//    1
//   / \
//  2   5
// / \   \
//3   4   6
//
// 将其展开为：
//
// 1
// \
//  2
//   \
//    3
//     \
//      4
//       \
//        5
//         \
//          6
// Related Topics 树 深度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public void flatten(TreeNode root) {
            if (root == null) {
                return;
            }
            TreeNode right = root.right;
            flatten(right);
            TreeNode left = root.left;
            root.left=null;

            if (left != null) {
                flatten(left);
                root.right =left;
                while (left.right != null) {
                    left = left.right;
                }
                left.right = right;
            }


        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}