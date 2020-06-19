package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;
import com.worker.bee.solution.bean.TreeNode;

import java.util.ArrayList;

/**
 * 题目标题:
 * 110. Balanced Binary Tree
 */
public class _110_BalancedBinaryTree {

    public static void main(String[] args) {
        Solution solution = new _110_BalancedBinaryTree().new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        PrintUtils.print(solution.isBalanced(root));

    }
//给定一个二叉树，判断它是否是高度平衡的二叉树。
//
// 本题中，一棵高度平衡二叉树定义为：
//
//
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
//
//
// 示例 1:
//
// 给定二叉树 [3,9,20,null,null,15,7]
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// 返回 true 。
//
//示例 2:
//
// 给定二叉树 [1,2,2,3,3,null,null,4,4]
//
//        1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
//
//
// 返回 false 。
//
//
// Related Topics 树 深度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)

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
        public boolean isBalanced(TreeNode root) {
            int treeDeep = getTreeDeep(root, 1);
            return treeDeep != -1;
        }

        private int getTreeDeep(TreeNode treeNode, int currentDeep) {
            if (treeNode == null) {
                return currentDeep - 1;
            }
            int  left = getTreeDeep(treeNode.left, currentDeep + 1);
            if (left == -1) {
                return -1;
            }
            int  right = getTreeDeep(treeNode.right, currentDeep + 1);
            if (right == -1) {
                return -1;
            }
            if (Math.abs(right - left) > 1) {
                return -1;
            }


            return Math.max(right, left);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}